package com.revert.core.demo.queryDB.jdbcTemplate.mapper;

import com.revert.modue.shiro.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DemoUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserModel> selectAllByUser(UserModel userModel){
        String sql = "select * from sys_user";
//        jdbcTemplate.query()
        return null;
    }

    public int selectAllCount(){
        String sql = "select count(1) from sys_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count.intValue() : 0;
    }


}
