package com.revert.core.platform.generator.controller;

import com.revert.core.platform.generator.model.SysTable;
import com.revert.core.platform.generator.service.SysTableService;
import com.revert.platform.common.base.result.web.WebResult;
import com.revert.platform.common.base.result.web.WebResultBuild;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/platform/api/v1/sysTable")
public class SysTableController {

    @Autowired
    private SysTableService sysTableService;

    @RequestMapping(method = {RequestMethod.GET})
    public WebResult<List<SysTable>> selectPage(SysTable sysTable){
        try {
            return new WebResultBuild<List<SysTable>>().data(sysTableService.selectByModel(sysTable)).build();
        }catch (Exception e){
            log.error("查询表信息异常",e);
            return new WebResultBuild<List<SysTable>>().code("500").message("服务器繁忙，请稍后再试。").build();
        }
    }

}
