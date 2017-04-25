<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript" src="resource/js/jquery-3.2.0.js" ></script>
    <script type="text/javascript" src="resource/js/spark-md5.js" ></script>
    <script type="text/javascript" src="resource/js/fileUploadPlugin.js" ></script>
    <script type="text/javascript" src="resource/js/Spark-md5-local.js" ></script>
    <body>
        <input type="file" multiple id="file" name="file" />
        <input type="button" onclick="uploadFile()" value="上传" />
        <div id="uploadValue">
        </div>
    </body>
    <script type="text/javascript">
        function uploadFile(){
        fileobj = document.getElementById("file").files;
        var nums = document.getElementById("file").files.length;
        var mark = 0;
            function calls(num){
                console.log("[DEBUG] calls invoked the mark = " + mark);
                $.ajax({
                    type:"POST",
                    url:"/PersonalCloudStorageSystem/checkMD5",
                    contentType:"text/xml",
                    async:true,
                    data:num,
                    dataType:"text",
                    success: function(data,textStaus){
                                console.log("[DEBUG] mark = " + mark + " file name :" + fileobj[mark]);
                                if(data=="0"){
                                    var s = new singleFileUpload();
                                    s.single(fileobj[mark],"/PersonalCloudStorageSystem/upload",num,function(evt){
                                        if(mark != nums){
                                            getFileMD5(fileobj[mark],calls);
                                        }
                                    });
                                }else{
                                    //将上传进度变更为100%，开始下一个文件上传
                                }
                                mark++;
                            }
                });
            }
            getFileMD5(fileobj[mark],calls);
        }

    </script>
</html>

