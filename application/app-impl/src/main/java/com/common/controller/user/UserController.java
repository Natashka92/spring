package com.common.controller.user;

import com.common.controller.AppController;
import com.common.dto.OutputListDTO;
import com.common.dto.user.UserOutputDTO;
import com.common.dto.user.UserInputDTO;
import com.common.services.user.UserLightWeighService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user", headers = "Accept=application/json")
public class UserController extends AppController {

    @Autowired
    private UserLightWeighService userLightWeightService;

    @RequestMapping(value="/all",
            method = RequestMethod.GET)
    public @ResponseBody
    OutputListDTO<UserOutputDTO> getList(){
        return userLightWeightService.findAll();
    }

    @RequestMapping(value="/{id}",
            method=RequestMethod.GET)
    public @ResponseBody UserOutputDTO findById(@PathVariable("id") Long id){
        return userLightWeightService.findById(id);
    }

    @RequestMapping(value="",
            method=RequestMethod.POST)
    public @ResponseBody UserOutputDTO create(@RequestBody @Valid UserInputDTO userDTO){
        return userLightWeightService.create(userDTO);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT)
    public @ResponseBody void update(@PathVariable("id") Long id,
                                     @RequestBody @Valid UserInputDTO userDTO){
        userLightWeightService.update(id, userDTO);
    }

    @RequestMapping(value="/{id}",
            method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") Long id){
        userLightWeightService.delete(id);
    }
}