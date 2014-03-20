package com.common.services.pizza;

import java.util.List;
import com.common.exception.pizza.PizzaNameAlreadyExistsException;
import com.common.exception.pizza.PizzaNotFoundException;
import com.common.exception.position.PositionNotFoundException;
import com.common.model.pizza.Pizza;


public interface PizzaService {

    /**
     * Add new pizza in system
     * @param pizza - new instance of pizza
     * @return  {@link Pizza}
     */
    public Pizza create(Pizza pizza)
        throws
            PizzaNameAlreadyExistsException;

    /**
     * Update pizza in system
     * @param pizza  - updated pizza
     * @throws PositionNotFoundException
     */
    public void update(Pizza pizza)
        throws
            PositionNotFoundException;

    /**
     * Find all pizzas
     * @return  {@link List<Pizza>}
     * @throws PizzaNotFoundException
     */
    public List<Pizza> getList()
        throws
            PizzaNotFoundException;

    /**
     * Delete pizza from system
     * @param id - id of chosen pizza
     * @throws PizzaNotFoundException
     */
    public void delete(Long id)
        throws
            PizzaNotFoundException;

    /**
     * Find pizza by id
     * @param id - id of chosen pizza
     * @return {@link Pizza}
     * @throws PizzaNotFoundException
     */
    public Pizza getById(Long id)
        throws
            PizzaNotFoundException;

    /**
     * Find pizza by name
     * @param Name - name of chosen pizza
     * @return  {@link }
     * @throws PizzaNotFoundException
     */
    public Pizza getByName(String Name)
        throws
            PizzaNotFoundException;
}