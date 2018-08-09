package com.revert.platform.common.base.result.web;

import java.io.Serializable;

public class WebResultBuild<T> implements Serializable {

    private String code = "200";

    private String message = "success";

    private T data;

    public WebResultBuild<T> code(String code){
        this.code = code;
        return this;
    }

    public WebResultBuild<T> code(Integer code){
        this.code = String.valueOf(code);
        return this;
    }

    public WebResultBuild<T> message(String message){
        this.message = message;
        return this;
    }

    public WebResultBuild<T> data(T data){
        this.data = data;
        return this;
    }

    public WebResult<T> build(){
        return new WebResult<T>(code, message, data);
    }

}
