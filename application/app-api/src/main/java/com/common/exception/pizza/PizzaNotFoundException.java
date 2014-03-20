package com.common.exception.pizza;

import com.common.annotation.AppExceptionKey;
import com.common.exception.AppException;

@AppExceptionKey("app.err.pizza.findError")
public class PizzaNotFoundException extends AppException{

}
