package com.common.controller.Pizza;

import com.common.controller.AppController;
import com.common.dto.OutputListDTO;
import com.common.dto.pizza.PizzaInputDTO;
import com.common.dto.pizza.PizzaOutputDTO;
import com.common.services.pizza.PizzaLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@RequestMapping(value ="/pizza", headers = "Accept=application/json")
public class PizzaController extends AppController {

    @Autowired
    private PizzaLightWeightService pizzaLightWeightService;

    @RequestMapping(value="/all",
                    method = RequestMethod.GET)
    public @ResponseBody OutputListDTO<PizzaOutputDTO> getList(){
        return pizzaLightWeightService.findAll();
    }

    @RequestMapping(value="/{id}",
                    method=RequestMethod.GET)
    public @ResponseBody PizzaOutputDTO findById(@PathVariable("id") Long id){
        return pizzaLightWeightService.findById(id);
    }

    @RequestMapping(value="",
                    method=RequestMethod.POST)
    public @ResponseBody PizzaOutputDTO create(@RequestBody @Valid PizzaInputDTO pizzaInputDTO){
        return pizzaLightWeightService.create(pizzaInputDTO);
    }

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.PUT)
    public @ResponseBody void update(@PathVariable("id") Long id,
                                     @RequestBody @Valid PizzaInputDTO pizzaInputDTO){
        pizzaLightWeightService.update(id, pizzaInputDTO);
    }

    @RequestMapping(value="/{id}",
                    method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") Long id){
        pizzaLightWeightService.delete(id);
    }
}