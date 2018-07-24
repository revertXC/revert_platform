package com.revert.core.platform.generator.service;

import com.revert.core.platform.generator.mapper.SysTableMapper;
import com.revert.core.platform.generator.model.SysTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysTableService {

    @Autowired
    private SysTableMapper sysTableMapper;

    public List<SysTable> selectByModel(SysTable sysTable){
        return this.sysTableMapper.selectByModel(sysTable);
    }


}
