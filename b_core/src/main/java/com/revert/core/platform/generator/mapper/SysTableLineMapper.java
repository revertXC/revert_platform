package com.revert.core.platform.generator.mapper;

import com.revert.core.platform.generator.model.SysTableLine;
import com.revert.platform.common.annotation.MasterMybatisDao;

import java.util.List;

@MasterMybatisDao
public interface SysTableLineMapper {

    /**
     * 查询数据库中的表 列
     * @param sysTableLine
     * @return
     */
    List<SysTableLine> selectByModel(SysTableLine sysTableLine);

}
