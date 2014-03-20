package com.common.controller;

import com.common.dto.error.ErrorDTO;
import com.common.exception.AppException;
import com.common.services.appUtils.AppMessageSourceService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class AppController {

    private static final String STR_XML_HTTP_REQUEST = "XMLHttpRequest";
    private static final String HEADER_X_REQUESTED = "X-Requested-With";


    @Autowired
    private AppMessageSourceService appMessageSourceService;

//    @ExceptionHandler(AppException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handleAppException(AppException error,
//                                     HttpServletRequest request,
//                                     ServletResponse response)
//        throws
//            Exception{
//        request.setAttribute("exception", error);
//        return "/unchecked";
//    }

    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleAppException(AppException error,
            HttpServletRequest request,
            ServletResponse response)
        throws
            Exception{
        writeError(error, error.getMessage(), request, response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody void handleMethodArgumentNotValidException(
            MethodArgumentNotValidException error,
            HttpServletRequest request,
            ServletResponse response)
        throws
            Exception{
        StringBuilder sb = new StringBuilder();
        for (ObjectError objectError: error.getBindingResult().getAllErrors()) {
            sb.append("\n\n -").append(appMessageSourceService.getMessage(objectError.getDefaultMessage()));
        }
        writeError(error, sb.toString(), request, response);
    }

    private boolean isAjax(
            HttpServletRequest request) {
        return STR_XML_HTTP_REQUEST.equals(request.getHeader(HEADER_X_REQUESTED));
    }

    private void writeError(final Throwable error,
            String message,
            HttpServletRequest request,
            ServletResponse response)
        throws
            Exception {
        response.setCharacterEncoding("UTF-8");
        if (isAjax(request)) {
            //response.setContentType("application/json");
            //final ObjectMapper mapper = new ObjectMapper();
            //mapper.writeValue(response.getOutputStream(), new ErrorDTO(error, message));
            response.setContentType("text/plain");
            response.getWriter().write(message);
        }
        else {
            response.setContentType("text/plain");
            response.getWriter().write(message);
        }
    }
}
