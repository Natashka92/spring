package com.common.controller.redirect.user;

import com.common.controller.AppController;
import com.common.dto.OutputListDTO;
import com.common.dto.user.UserOutputDTO;
import com.common.services.user.UserLightWeighService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@Secured(value = "ROLE_ADMIN")
@RequestMapping(value ="/user")
public class UserRedirectController extends AppController {

    private static final String PAGE_USER_LIST = "/user/list";
    private static final String PAGE_USER_EDIT = "/user/edit";

    @Autowired
    private UserLightWeighService userLightWeightService;

    @RequestMapping("/list")
    public String getList(ModelMap modelMap) {
        OutputListDTO<UserOutputDTO> userList =  userLightWeightService.findAll();
        modelMap.addAttribute("userList", userList.getData());
        return PAGE_USER_LIST;
    }

    @RequestMapping(value = "/edit/{id}",
                    method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id,
                       ModelMap modelMap) {
        UserOutputDTO userDTO = userLightWeightService.findById(id);
        modelMap.addAttribute("userDTO", userDTO);
        modelMap.addAttribute("userID", id);
        return PAGE_USER_EDIT;
    }
}
