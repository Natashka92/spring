package com.common.dao.pizza;

import com.common.model.pizza.Pizza;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaDAOImpl implements PizzaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Pizza update(Pizza pizza) {
        sessionFactory.getCurrentSession().merge(pizza);
        return pizza;
    }

    public void create(Pizza pizza){
        sessionFactory.getCurrentSession().persist(pizza);
    }

    @SuppressWarnings("unchecked")
	public List<Pizza> getList() {
        return sessionFactory.getCurrentSession().getNamedQuery(Pizza.NamedQuery.PIZZA_FIND_ALL).list();
    }

    public void delete(Long id) {
    	Pizza pizza = getById(id);
        if (null != pizza) {
            sessionFactory.getCurrentSession().delete(pizza);
        }
    }
    
    public Pizza getById(Long id){
        Query query = sessionFactory.getCurrentSession().getNamedQuery(Pizza.NamedQuery.PIZZA_FIND_BY_ID);
        query.setLong("id", id);
        return (Pizza) query.uniqueResult();
    }

    public Pizza getByName(String name){
        Query query = sessionFactory.getCurrentSession().getNamedQuery(Pizza.NamedQuery.PIZZA_FIND_BY_NAME);
        query.setString("name", name);
        return (Pizza) query.uniqueResult();
    }
}