package com.revert.core.platform.generator.mapper;

import com.revert.core.platform.generator.model.SysTable;
import com.revert.platform.common.annotation.MasterMybatisDao;

import java.util.List;

@MasterMybatisDao
public interface SysTableMapper {

    /**
     * 查询数据库中的表
     * @param sysTable
     * @return
     */
    List<SysTable> selectByModel(SysTable sysTable);

}
