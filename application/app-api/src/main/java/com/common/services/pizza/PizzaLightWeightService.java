package com.common.services.pizza;

import com.common.dto.*;
import com.common.dto.pizza.PizzaOutputDTO;
import com.common.dto.pizza.PizzaInputDTO;
import com.common.exception.pizza.PizzaNameAlreadyExistsException;
import com.common.exception.pizza.PizzaNotFoundException;
import com.common.exception.position.PositionNotFoundException;

public interface PizzaLightWeightService {

    /**
     * Find all pizzas
     * @return  {@link OutputListDTO<PizzaOutputDTO>}
     * @throws PizzaNotFoundException
     */
    OutputListDTO<PizzaOutputDTO> findAll()
        throws
            PizzaNotFoundException;

    /**
     * Find pizza by id
     * @param id - id of chosen pizza
     * @return  {@link PizzaOutputDTO}
     * @throws PizzaNotFoundException
     */
    PizzaOutputDTO findById(final Long id)
        throws
            PizzaNotFoundException;

    /**
     * Create Pizza object in the system
     * @param pizzaDTO - DTO with description for create new pizza
     * @return {@link PizzaInputDTO}
     */
    PizzaOutputDTO create(PizzaInputDTO pizzaDTO)
        throws
            PizzaNameAlreadyExistsException;

    /**
     * Update Pizza object in the system
     * @param id - pizza id
     * @param pizzaDTO - DTO with description for the pizza being updated
     * @throws PizzaNotFoundException
     * @throws PositionNotFoundException
     */
    void update(Long id, PizzaInputDTO pizzaDTO)
        throws
            PizzaNotFoundException,
            PositionNotFoundException;

    /**
     * Delete pizza from system
     * @param id - id of chosen pizza
     * @throws PizzaNotFoundException
     */
    void delete(Long id)
        throws
            PizzaNotFoundException;
}
