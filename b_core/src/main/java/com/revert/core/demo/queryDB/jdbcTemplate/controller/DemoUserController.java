package com.revert.core.demo.queryDB.jdbcTemplate.controller;

import com.revert.core.demo.queryDB.jdbcTemplate.service.DemoUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
@RequestMapping("demo/user")
public class DemoUserController {

    @Autowired
    private DemoUserService demoUserService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int selectAllCount(){
        int count = demoUserService.selectAllCount();
//        log.error("个数"+count);
//        log.info("个数"+count);
//        log.warn("个数"+count);
        return count;
    }

}
