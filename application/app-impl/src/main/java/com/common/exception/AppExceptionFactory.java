package com.common.exception;

import com.common.annotation.AppExceptionKey;
import com.common.services.appUtils.AppMessageSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppExceptionFactory
{
    @Autowired
    private AppMessageSourceService messageService;

    public <T extends AppException> T getAppException(Class<T> clazz, Object ... args){
        T appException;

        try{
            AppExceptionKey appExceptionKey = clazz.getAnnotation(AppExceptionKey.class);
            String key = appExceptionKey.value();
            appException = (T) clazz.newInstance();
            appException.setMessage(messageService.getMessage(key, args));
        }
        catch (InstantiationException e)         {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e)        {
            throw new RuntimeException(e);
        }
        return (T) appException;
    }
}
