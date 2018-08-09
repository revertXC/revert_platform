package com.revert.core.platform.generator.model;

import com.revert.core.platform.generator.utils.GeneratorUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GeneratorVO implements Serializable{

    /** 包名  com.revert.xx.xxx */
    private String packageName;

    /** 类名 */
    private String className;


    public void conv(SysTable sysTable, String packageName){
        this.packageName = packageName;
        if(sysTable.getPrefixAdd() == 0){
            className = sysTable.getTableName();
        }else{
            className = GeneratorUtil.captalAfter(sysTable.getTableName(), "_");
        }
    }

}
