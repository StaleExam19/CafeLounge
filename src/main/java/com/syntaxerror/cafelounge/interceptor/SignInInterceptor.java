package com.syntaxerror.cafelounge.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class SignInInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception {

        Object userSession = WebUtils.getSessionAttribute(request, "user");
        if (userSession == null) {
            response.sendRedirect(request.getContextPath() + "/signin");
            return false;
        }
        
        return true;
    }

}
