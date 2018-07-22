package com.revert.platform.common.base.result.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebResult<T> implements Serializable {

    private String code = "200";

    private String message = "success";

    private T data;

}
