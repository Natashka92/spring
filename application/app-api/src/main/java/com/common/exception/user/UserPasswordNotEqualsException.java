package com.common.exception.user;

import com.common.annotation.AppExceptionKey;
import com.common.exception.AppException;


@AppExceptionKey("app.err.user.password.equals")
public class UserPasswordNotEqualsException extends AppException {
}