package com.revert.core.platform.generator.service;

import com.revert.core.platform.generator.mapper.SysTableLineMapper;
import com.revert.core.platform.generator.mapper.SysTableMapper;
import com.revert.core.platform.generator.model.SysTable;
import com.revert.core.platform.generator.model.SysTableLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysTableLineService {

    @Autowired
    private SysTableLineMapper sysTableLineMapper;

    public List<SysTableLine> selectByModel(SysTableLine sysTableLine){
        return this.sysTableLineMapper.selectByModel(sysTableLine);
    }


}
