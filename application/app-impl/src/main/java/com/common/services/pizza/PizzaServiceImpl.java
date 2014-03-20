package com.common.services.pizza;

import java.util.List;
import com.common.exception.AppExceptionFactory;
import com.common.exception.pizza.PizzaNameAlreadyExistsException;
import com.common.exception.pizza.PizzaNotFoundException;
import com.common.exception.position.PositionNotFoundException;
import com.common.model.pizza.Pizza;
import com.common.dao.pizza.PizzaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private AppExceptionFactory appExceptionFactory;

    @Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
    public Pizza create(Pizza pizza)
        throws
            PizzaNameAlreadyExistsException{
        if(pizzaDAO.getByName(pizza.getName())!= null){
            throw appExceptionFactory.getAppException(PizzaNameAlreadyExistsException.class);
        }

        pizzaDAO.create(pizza);
        return pizza;
    }

    @Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(Pizza pizza)
        throws
            PositionNotFoundException {
        if(pizzaDAO.getById(pizza.getId()) == null){
            throw appExceptionFactory.getAppException(PositionNotFoundException.class);
        }
        pizzaDAO.update(pizza);
    }

    @Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Pizza> getList()
        throws
            PizzaNotFoundException{
        List<Pizza> pizzas = pizzaDAO.getList();
        if(pizzas== null){
            throw appExceptionFactory.getAppException(PizzaNotFoundException.class);
        }
        return pizzas;
    }

    @Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id)
        throws
            PizzaNotFoundException{
        Pizza pizza = pizzaDAO.getById(id);
        if(pizza == null){
            throw appExceptionFactory.getAppException(PizzaNotFoundException.class);
        }
        pizzaDAO.delete(id);
    }
    
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public Pizza getById(Long id)
        throws
            PizzaNotFoundException{
        Pizza pizza = pizzaDAO.getById(id);
        if(pizza == null){
            throw appExceptionFactory.getAppException(PizzaNotFoundException.class);
        }
		return pizza;
	}

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Pizza getByName(String name)
        throws
            PizzaNotFoundException {
        Pizza pizza = pizzaDAO.getByName(name);
        if(pizza == null){
            throw appExceptionFactory.getAppException(PizzaNotFoundException.class);
        }
        return pizza;
    }
}