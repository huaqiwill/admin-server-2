package com.example.demo.handler;

import com.example.demo.commom.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<?> handleException(Exception e) {
        e.printStackTrace();
        return Result.error("1", e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<?> handleException(MethodArgumentNotValidException e) {
        return Result.error("1", Objects.requireNonNull(e.getFieldError()).getDefaultMessage());
    }

}