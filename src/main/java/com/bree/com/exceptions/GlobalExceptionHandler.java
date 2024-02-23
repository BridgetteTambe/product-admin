package com.bree.com.exceptions;

import com.bree.com.exceptions.dto.ExceptionResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler
    public ExceptionResponse exception(Exception e) {
        return new ExceptionResponse(e.getMessage());
    }
}
