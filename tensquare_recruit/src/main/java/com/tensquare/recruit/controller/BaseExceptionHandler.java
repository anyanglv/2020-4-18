package com.tensquare.recruit.controller;
import entity.ReturnResult;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 统一异常处理类
 */
@ControllerAdvice
public class BaseExceptionHandler {
	
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnResult error(Exception e){
        e.printStackTrace();        
        return new ReturnResult( StatusCode.ERROR, false,"执行出错");
    }
}
