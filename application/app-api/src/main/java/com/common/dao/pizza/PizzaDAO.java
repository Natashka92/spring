package com.common.dao.pizza;

import com.common.model.pizza.Pizza;
import java.util.List;


public interface PizzaDAO {

    /**
     * Add new pizza in system
     * @param pizza - new instance of pizza
     */
    public void create(Pizza pizza);

    /**
     * Update pizza in system
     * @param pizza  - updated pizza
     * @return  {@link Pizza}
     */
    public Pizza update(Pizza pizza);

    /**
     * Find all pizzas
     * @return  List<Pizza>
     */
    public List<Pizza> getList();

    /**
     * Delete pizza from system
     * @param id - id of chosen pizza
     */
    public void delete(Long id);

    /**
     * Find pizza by id
     * @param id - id of chosen pizza
     * @return Pizza
     */
    public Pizza getById(Long id);


    /**
     * Find pizza by login
     * @param name - name of chosen pizza
     * @return  {@link Pizza}
     */
    public Pizza getByName(String name);
}