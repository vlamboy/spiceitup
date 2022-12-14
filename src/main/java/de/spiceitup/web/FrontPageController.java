package de.spiceitup.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontPageController {

    @GetMapping(path = "/")
    public ModelAndView showFrontPage(){
        return new ModelAndView("frontpage");
    }
}
