package indi.group.pcss.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class CheckLoginController {
    @GetMapping("")
    public String check(HttpServletRequest request, @CookieValue(value = "token",required = false) String ck) {
        if(ck == null) return "redirect:Login";
        if(ck.equals("123123"))
            return "redirect:loginsuccess";
        else{
            return "redirect:Login";
        }
    }
    @RequestMapping("/loginsuccess")
    public String lo(HttpServletRequest request ,HttpServletResponse response){
        request.setAttribute("usedspace", "100MB");
        request.setAttribute("totalspace", "50GB");
        request.setAttribute("percent", "70%");
        request.setAttribute("username", "熊诚");
        Cookie cookie = new Cookie("token", "123123");
        response.addCookie(new Cookie("token", "123123"));
        return "loginsuccess";
    }
}
