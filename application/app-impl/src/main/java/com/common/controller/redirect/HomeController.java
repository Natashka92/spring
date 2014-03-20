package com.common.controller.redirect;

import com.common.controller.AppController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController extends AppController {
    @RequestMapping(value = "/myString",  method = RequestMethod.GET)
    @ResponseBody
    public String obj() {
        return "Hello!";
    }
}
