package com.revert.core.platform.generator.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 表列
 */
@Setter
@Getter
public class SysTableLine {

    /**表名*/
    private String tableName;

    /**列名*/
    private String columnName;

    /**列名 对应数据库对应数据类型*/
    private String jdbcDataType;

    /**转成 java 类型*/
    private String javaDataType;

    /**备注*/
    private String comment;


    public String getJavaDataType(){
        String type = null;
        switch (jdbcDataType){
            case "int":
                type = "Integer";
                break;
            case "bigint":
                type = "Long";
                break;
            case "datetime":
                type = "Date";
                break;
            default:
                type = "String";
                break;
        }
        return type;
    }



}
