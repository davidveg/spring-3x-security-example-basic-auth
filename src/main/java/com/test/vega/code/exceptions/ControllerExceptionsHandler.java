package com.test.vega.code.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler
    public String productNotFoundHandler(ProductNotFoundException ex) {
        return ex.getMessage();
    }


}
