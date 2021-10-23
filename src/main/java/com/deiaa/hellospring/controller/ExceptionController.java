package com.deiaa.hellospring.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController extends SimpleMappingExceptionResolver {

    @ExceptionHandler(value=Exception.class)
    public String handException(HttpServletRequest req , Exception ex){
       // System.out.println("REQ "+ req.getRequestURI() + " Error "+ex);
        return "error";
    }
}
