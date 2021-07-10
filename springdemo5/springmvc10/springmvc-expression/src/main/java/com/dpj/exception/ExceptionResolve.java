package com.dpj.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ExceptionResolve implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        if (ex instanceof MyException){
            ModelAndView mv  = new ModelAndView();
            mv.addObject("errorMessage",ex.getMessage());
            mv.setViewName("error.jsp");
            return mv;
        }
        return null;
    }
}
