package com.common.model.pizza;

import com.common.model.IdentifierEntity;
import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Pizza.NamedQuery.PIZZA_FIND_ALL, query = "from Pizza"),
        @NamedQuery(name = Pizza.NamedQuery.PIZZA_FIND_BY_ID, query = "from Pizza where id = :id"),
        @NamedQuery(name = Pizza.NamedQuery.PIZZA_FIND_BY_NAME, query = "from Pizza where name =:name")})


@Entity
@Table(name = "pizza")
public class Pizza extends IdentifierEntity {

    @Column(name="name", length = 45, nullable = false, unique = true )
    private String name;

    @Column(name="price")
    private Double price;

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Pizza() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static class NamedQuery {
        public static final String PIZZA_FIND_ALL = "Pizza.findAll";
        public static final String PIZZA_FIND_BY_ID = "Pizza.findById";
        public static final String PIZZA_FIND_BY_NAME = "Pizza.findByName";
    }
 }


