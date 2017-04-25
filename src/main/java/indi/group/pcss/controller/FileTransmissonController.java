package indi.group.pcss.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
/*
 * Handlers requests for the application filetransmission function
 * 
 */
@Controller
public class FileTransmissonController {
    private static final Logger logger = LoggerFactory.getLogger(FileTransmissonController.class);
    /**
     * level:Debug
     * describle:
     * This function use for test fileupload when the developer want to test fileupload 
     * this function will be redirect to filetest.jsp
     * @return redirect to filetest.jsp
     */
    @RequestMapping("/filetest")
    public String index() {
        logger.debug("filetest.jsp has been request");
        return "filetest";
    }
    
    /**
     * Describle:
     * Use for accept user file to file saving location
     * Saving location is "E:/cache/{filename}"
     * 
     * if file saving success ,will return "success" message 
     * else return "fail + {failed reason detail}" message
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String springfileUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        logger.debug("Check is Multipart = " + multipartResolver.isMultipart(request));
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multirequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> list = multirequest.getFiles("xc");
            String filemd5 = multirequest.getParameter("filemd5");
            
            logger.debug("getAttribute value [" + filemd5 + "]");
            logger.debug("List<MultipartFile> lenth = " + list.size());
            for (MultipartFile file : list) {
                String filename = file.getOriginalFilename();
                //此处要加入对于数据库的操作，添加文件MD5值
                
                String path = "E:/cache/" + filemd5 + filename.substring(filename.lastIndexOf("."));
                logger.info("file upload controller read the save path is : " + path);
                file.transferTo(new File(path));
            }
        }
        //response.addCookie(new Cookie("login", Utils));
        return "success"; 
    }
    /**
     * Describle:
     * filedownload
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String filename) throws IOException {
        logger.debug("filename = " + filename);
        File file = new File("E:/cache/" + filename);
        logger.debug("download functiong has been invoked request file Absolute path is " + file.getAbsolutePath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachement", filename);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
    @RequestMapping("/checkMD5")
    @ResponseBody
    public String checkMD5(@RequestBody String md5){
        logger.debug("md5 = " + md5);
        return "0";
    }
}
