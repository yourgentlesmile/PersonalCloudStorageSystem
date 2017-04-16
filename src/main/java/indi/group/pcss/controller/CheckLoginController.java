package indi.group.pcss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckLoginController {
    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView check() {
        return new ModelAndView("redirect:Login");
    }
}
