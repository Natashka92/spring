package com.common.controller.redirect;

import com.common.controller.AppController;
import com.common.dto.user.UserRegisterDTO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Secured(value="ROLE_ANONYMOUS")
public class RegistrationRedirectController extends AppController{

    private final static String USER_REGISTRATION = "user/registration";

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration (ModelMap modelMap) {
        return USER_REGISTRATION;
    }

}
