package indi.group.pcss.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import indi.group.pcss.model.User;

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
    public String home(Locale locale) {
        logger.debug("Index.jsp has been requested");
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
    public User loginCheck(@RequestBody User user) {
    	logger.debug("username:{0},password:{1}",user.getUsername(),user.getPassword());
    	return user;
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
     * 
     */
}
