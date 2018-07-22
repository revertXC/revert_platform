package com.revert.platform.common.base.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

/**
 * 需要的分页参数
 */
@Getter
@Setter
public class BasePageInfo implements Serializable {

    /**当前页*/
    private Integer pageNum;

    /**每页条数*/
    private Integer pageSize;

    /**总数*/
    private Long total;

    /**总页数*/
    private Integer totalNum;

    private Collection data;


}
