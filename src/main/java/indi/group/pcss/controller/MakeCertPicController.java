package indi.group.pcss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MakeCertPicController {
    @RequestMapping(value = "/makeCerPic", method = RequestMethod.GET)
    public String getPic() {
        return "makeCerPic";
    }
}
