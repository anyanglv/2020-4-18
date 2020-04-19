package com.tensquare.base.controller;

import entity.ReturnResult;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/4/19
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
@RestControllerAdvice
public class BaseExceptionHandLer {

    @ExceptionHandler(Exception.class)
    public ReturnResult error(Exception e) {
        return new ReturnResult(StatusCode.ERROR,false,e.getMessage());
    }
}
