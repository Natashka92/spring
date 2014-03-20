package com.common.dto.pizza;

import com.common.dto.IInputDTO;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="pizza")
public class PizzaInputDTO implements IInputDTO{

    @NotEmpty(message = "valid.err.pizza.title.required")
    @Length(min=1, max=20, message = "valid.err.pizza.title.range")
    private String name;

    @NotNull(message = "valid.err.pizza.price.required")
    @Min(value = 0, message = "valid.err.pizza.price.range")
    private double price;

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
}
