package com.common.dto.pizza;

import com.common.dto.GenericDTOFactory;
import com.common.dto.OutputListDTO;
import com.common.model.pizza.Pizza;
import org.springframework.stereotype.Component;


@Component
public class PizzaDTOFactory extends GenericDTOFactory<Pizza, PizzaInputDTO, PizzaOutputDTO, OutputListDTO<PizzaOutputDTO>> {

    public Pizza initModel(PizzaInputDTO dto){
        Pizza pizza = new Pizza();
        updateModel(pizza, dto);
        return pizza;
    }

    @Override
    public PizzaOutputDTO createOutputDTO(Pizza pizza){
        PizzaOutputDTO dto = null;
        if(pizza != null){
            dto = super.createOutputDTO(pizza);
            dto.setName(pizza.getName());
            dto.setPrice(pizza.getPrice());
        }
        return dto;
    }

    public void updateModel(Pizza pizza, PizzaInputDTO dto){
        pizza.setName(dto.getName());
        pizza.setPrice(dto.getPrice());
    }

    @Override
    protected PizzaInputDTO getInputDTO() {
        return new PizzaInputDTO();
    }

    @Override
    protected PizzaOutputDTO getOutputDTO(){
        return new PizzaOutputDTO();
    }

    @Override
    protected OutputListDTO<PizzaOutputDTO> getNewListDTO() {
        return new OutputListDTO<PizzaOutputDTO>();
    }
}
