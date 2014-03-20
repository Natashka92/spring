package com.common.services.pizza;

import com.common.dto.OutputListDTO;
import com.common.dto.pizza.PizzaDTOFactory;
import com.common.dto.pizza.PizzaInputDTO;
import com.common.dto.pizza.PizzaOutputDTO;
import com.common.exception.pizza.PizzaNameAlreadyExistsException;
import com.common.exception.pizza.PizzaNotFoundException;
import com.common.exception.position.PositionNotFoundException;
import com.common.model.pizza.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PizzaLightWeightServiceImpl implements PizzaLightWeightService {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PizzaDTOFactory pizzaDTOFactory;

    @Override
    public OutputListDTO<PizzaOutputDTO> findAll()
        throws
            PizzaNotFoundException{
        return pizzaDTOFactory.createListDTO(pizzaService.getList());
    }

    @Override
    public PizzaOutputDTO findById(Long id)
        throws
            PizzaNotFoundException {
        return pizzaDTOFactory.createOutputDTO(pizzaService.getById(id));
    }

    @Override
    public PizzaOutputDTO create(PizzaInputDTO pizzaDTO)
        throws
            PizzaNameAlreadyExistsException {
        Pizza pizza = pizzaDTOFactory.initModel(pizzaDTO);
        return pizzaDTOFactory.createOutputDTO(pizzaService.create(pizza));
    }

    @Override
    public void update(Long id, PizzaInputDTO pizzaDTO)
        throws
            PizzaNotFoundException,
            PositionNotFoundException {
        Pizza pizza = pizzaService.getById(id);
        pizzaDTOFactory.updateModel(pizza, pizzaDTO);
        pizzaService.update(pizza);
    }

    @Override
    public void delete(Long id)
        throws
            PizzaNotFoundException {
        pizzaService.delete(id);
    }
}
