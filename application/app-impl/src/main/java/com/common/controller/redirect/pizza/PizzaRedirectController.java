package com.common.controller.redirect.pizza;

import com.common.controller.AppController;
import com.common.dto.OutputListDTO;
import com.common.dto.pizza.PizzaOutputDTO;
import com.common.services.pizza.PizzaLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@Secured(value ="ROLE_USER")
@RequestMapping(value = "/pizza", method = RequestMethod.GET)
public class PizzaRedirectController extends AppController {

    private static final String PAGE_PIZZA_LIST = "/pizza/list";
    private static final String PAGE_CREATE_PIZZA = "/pizza/create";

    @Autowired
    private PizzaLightWeightService pizzaLightWeightService;

    @RequestMapping(value = "/list")
    public String getAll(ModelMap modelMap) {
        OutputListDTO<PizzaOutputDTO> pizzaList =  pizzaLightWeightService.findAll();
        modelMap.addAttribute("pizzaList", pizzaList.getData());
        return PAGE_PIZZA_LIST;
    }

    @RequestMapping(value = "/create")
    public String create(ModelMap modelMap){
        return PAGE_CREATE_PIZZA;
    }
}
