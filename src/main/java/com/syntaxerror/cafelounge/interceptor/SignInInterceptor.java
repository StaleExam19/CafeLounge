package com.syntaxerror.cafelounge.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.syntaxerror.cafelounge.dto.ChefDto;

public class SignInInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception {

        ChefDto userSession = (ChefDto) WebUtils.getSessionAttribute(request, "user");
        if (userSession == null) {
            response.sendRedirect(request.getContextPath() + "/signin");
            return false;
        }
        
        return true;
    }

}
