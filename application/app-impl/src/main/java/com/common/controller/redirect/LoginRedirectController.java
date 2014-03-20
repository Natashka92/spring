package com.common.controller.redirect;


import com.common.data.Authorities;
import com.common.model.security.SecurityUserDetails;
import com.common.services.appUtils.AppMessageSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.security.core.Authentication;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@Controller
public class LoginRedirectController {

    private static final String LOGIN_PAGE = "login";
    private static final String ERROR_PAGE = "error";
    private static final String ADMIN_PAGE = "redirect:user/list";
    private static final String USER_PAGE = "home";

    private static final String BAD_CREDENTIALS_MESSAGE_CODE = "login.error.bad";
    private static final String USER_LOGGEDIN_MESSAGE_CODE = "login.error.user.already.loggedi";
    private static final String COMMON_LOGIN_ERROR_MESSAGE_CODE = "login.error.authentication";


    @Autowired
    private AppMessageSourceService appMessageSourceService;


    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(WebRequest webRequest, ModelMap modelMap){
        String errorMessageCode = getLoginErrorMessageCode(webRequest);

        if(errorMessageCode != null){
            modelMap.addAttribute("errorMessage", appMessageSourceService.getMessage(errorMessageCode));
        }
        return LOGIN_PAGE;
    }

    private String getLoginErrorMessageCode(WebRequest webRequest){
        Object lastException = webRequest.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, webRequest.SCOPE_SESSION);
        String errorMessageCode = null;

        if(lastException != null){
            if(lastException instanceof BadCredentialsException){
                errorMessageCode = BAD_CREDENTIALS_MESSAGE_CODE;
            }
            else if(lastException instanceof SessionAuthenticationException){
                errorMessageCode = USER_LOGGEDIN_MESSAGE_CODE;
            }
            else if(lastException instanceof AuthenticationException){
                errorMessageCode = COMMON_LOGIN_ERROR_MESSAGE_CODE;
            }
        }
        return errorMessageCode;
    }

    @RequestMapping(value ="/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(ModelMap modelMap){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()){
            SecurityUserDetails securityUserDetails = (SecurityUserDetails) authentication.getPrincipal();
            Collection<GrantedAuthority> grantedAuthorityCollection = securityUserDetails.getAuthorities();
            modelMap.addAttribute("user", securityUserDetails.getUsername());
            if(grantedAuthorityCollection != null){
                List<String> roleList =  new LinkedList<String>();
                Iterator<GrantedAuthority> grantedAuthorityIterator = grantedAuthorityCollection.iterator();
                while(grantedAuthorityIterator.hasNext()){
                    roleList.add(grantedAuthorityIterator.next().getAuthority());
                }

                if(roleList.contains(Authorities.ROLE_ADMIN.getName())){
                    return ADMIN_PAGE;
                }
                return USER_PAGE;
            }
        }
        return ERROR_PAGE;
    }
}
