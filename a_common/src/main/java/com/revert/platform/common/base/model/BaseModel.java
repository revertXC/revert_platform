package com.revert.platform.common.base.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseModel implements Serializable {

    /**ID*/
    private Long id;

    /** UUID*/
    private String uuid;

    /**备注*/
    private String remark;

    /**状态  state不是mysql关键字 status 是mysql 关键字*/
    private Integer state;

    /**创建时间*/
    private Date createDate;

    /**创建人ID*/
    private Long createBy;

    /**最后修改时间*/
    private Date updateDate;

    /**最后修改人ID*/
    private Long updateBy;

    /**标记是否删除 0否 1是*/
    private Integer deleted;

    /**当前页*/
    private int pageNum = 1;

    /**每页条数*/
    private int pageSize = 15;

    private String OrderBy;

}
