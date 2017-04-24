package indi.group.pcss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import indi.group.pcss.model.User;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/Login")
public class LoginController {
	
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    public static String safecode="";
    /**
     * Describle:
     * This function use for recv null args (doesn't include "/" ) and return main page to user browse
     * 此方法接受0参数url请求，value="",并返回Index给用户，即重定向到主页
     */
    @GetMapping("")
    public String home(HttpServletRequest request) {
        logger.debug("Index.jsp has been invoked");
        logger.info("the user ip is {}", getIpAddr(request));
        return "Index";
	}
    /**
     * Describle:
     * This function use for push verification code to user browse 
     * 此方法用于前端获取验证码的String形式
     */
    @GetMapping("/getsafecode")
    @ResponseBody
    public String getSafeCode() {
        logger.debug("getSafeCode hes been invoked");
        return safecode;
    }
    /**
     * Describle:
     * This function use for validate user submitted username and password
     * When check passed this function will redirct to......(doesn't realization)
     */
    @PostMapping("/LoginCheck")
    @ResponseBody
    public User loginCheck(@RequestBody String value, HttpServletRequest request) {
        JSONObject jobject = JSONObject.parseObject(value);
    	logger.info("Username:{},password:{}, have checkbox: {}", jobject.get("username"), jobject.get("password"), jobject.get("autoLogin"));
    	logger.info("The user ip is {}", getIpAddr(request));
    	return null;
    }
    /**
     * Describle:
     * 测试URL传值
     */
    @GetMapping("/requestTest/{arg1}/{arg2}")
    @ResponseBody
    public String requestTest(@PathVariable(value="arg1") int inputArgs1,@PathVariable(value="arg2") int inputArgs2) {
        return "" + inputArgs1 + inputArgs2;
    }
    /**
     * Describle:
     * 用来测试请求路径下的子路径请求
     * 本案例下：/Login下的reqtest
     */
    @GetMapping("/reqtest")
    @ResponseBody
    public String reqtest() {
        logger.debug("ReqTest has been invoked");
        return "Recv from reqtest function";
    }
    /**
     * Describle:
     * 获取request中的客户端IP地址
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }
}
