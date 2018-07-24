package com.revert.core.platform.generator.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SysTable implements Serializable {

    /**表名*/
    private String tableName;

    /**表数据个数*/
    private Integer ableRow;

    /**表类型*/
    private String tableType;

    /**表描述*/
    private String tableComment;

}
