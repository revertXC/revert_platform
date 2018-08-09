package com.revert.platform.common.base.controller;

import com.revert.platform.common.base.result.web.WebResult;
import com.revert.platform.common.base.result.web.WebResultBuild;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * controller 统一处理异常返回
 */
@Log4j2
@RestControllerAdvice
public class BaseExceptionControllerAdvice {



    @ExceptionHandler({Exception.class})
    public WebResult<String> exceptionResult(Exception e){
        log.error("controller异常"+e.getMessage(),e);
        return new WebResultBuild<String>().code(500).message("系统繁忙，请稍后再试。").build();
    }


}
