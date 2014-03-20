package com.common.exception.pizza;


import com.common.annotation.AppExceptionKey;
import com.common.exception.AppException;

@AppExceptionKey("app.err.pizza.name.exist")
public class PizzaNameAlreadyExistsException extends AppException{

}
