package com.revert.core.platform.generator.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 表
 */
@Getter
@Setter
public class SysTable implements Serializable {

    /**表名*/
    private String tableName;

    /**表数据个数*/
    private Integer tableRow;

    /**表类型*/
    private String tableType;

    /**表描述*/
    private String tableComment;

    /** 表列*/
    private List<SysTableLine> listTableLine;

    /** 包名  com.revert.xx.xxx */
    private String packageName;

    /** 表名前缀是否需要加（0否 1是） 值为0：sys_user = SysUser ; 值为1：sys_user = User  */
    private int prefixAdd = 0;

}
