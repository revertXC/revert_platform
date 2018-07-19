package com.revert.core.demo.queryDB.jdbcTemplate.service;

import com.revert.core.demo.queryDB.jdbcTemplate.mapper.DemoUserDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DemoUserService {

    @Autowired
    private DemoUserDao userDao;

    public int selectAllCount(){
        try {
            return userDao.selectAllCount();
        }catch (Exception e){
            log.error("查询用户表（sys_user）总数异常",e);
        }
        return 0;
    }
}
