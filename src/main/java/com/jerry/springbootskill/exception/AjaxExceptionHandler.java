package com.jerry.springbootskill.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AjaxExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req,
                                      Exception e) throws Exception {

        e.printStackTrace();
        return e.getMessage();
    }
}