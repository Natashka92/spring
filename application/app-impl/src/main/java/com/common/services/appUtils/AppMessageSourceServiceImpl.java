package com.common.services.appUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import java.util.Locale;
import java.util.logging.Logger;


@Service
public class AppMessageSourceServiceImpl implements  AppMessageSourceService{
    private Logger log = Logger.getLogger(AppMessageSourceServiceImpl.class.getName());

    @Autowired
    private MessageSource messageSource;


    @Override
    public String getMessage(String code){
        return getMessage(code, null);
    }


    @Override
    public String getMessage(String code, Object[] args){
        try{
            return messageSource.getMessage(code, args, getUserLocale());
        }
        catch (NoSuchMessageException e){
            return prepareErrMessage(code);
        }
    }

    @Override
    public String getMessage(String code, Object[] args, String defaultMessage){
        return messageSource.getMessage(code, args, defaultMessage, getUserLocale());
    }

    @Override
    public String getMessage(boolean val){
        return getMessage(val? "true" : "false");
    }

    private Locale getUserLocale()
    {
        return LocaleContextHolder.getLocale();
    }

    public String prepareErrMessage(String code){
        String msg = "Please add the following message key to Resource Bundle. Resource Bundle has no '" + code + "' message key";
        log.info(msg);
        return msg;
    }
}
