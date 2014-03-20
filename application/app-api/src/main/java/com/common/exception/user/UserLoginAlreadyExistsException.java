package com.common.exception.user;


import com.common.annotation.AppExceptionKey;
import com.common.exception.AppException;

@AppExceptionKey("app.err.user.login.Exist")
public class UserLoginAlreadyExistsException extends AppException{

}
