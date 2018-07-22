package com.revert.modue.shiro.user.controller;

import com.revert.modue.shiro.user.model.UserModel;
import com.revert.modue.shiro.user.service.UserService;
import com.revert.platform.common.annotation.LogicDelete;
import com.revert.platform.common.base.model.BasePageInfo;
import com.revert.platform.common.base.result.web.WebResult;
import com.revert.platform.common.base.result.web.WebResultBuild;
import com.revert.platform.common.constant.WebResultConstant;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api/v1/user")
@Log4j2
@LogicDelete
public class UserController{

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param userModel
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET})
    public WebResult<BasePageInfo> selectByPage(UserModel userModel){
        BasePageInfo basePageInfo = userService.selectByPage(userModel);
        return new WebResultBuild<BasePageInfo>().data(basePageInfo).build();
    }

    /**
     * 查询全部
     * @param userModel
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET})
    public WebResult<List<UserModel>> selectAll(UserModel userModel){
        List<UserModel> listUser = userService.selectByModel(userModel);
        return new WebResultBuild<List<UserModel>>().data(listUser).build();
    }


    /**
     * 增加
     * @param userModel
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST})
    public WebResult<String> insert(UserModel userModel){
        try{
            userService.insertAll(userModel);
        }catch (Exception e){
            return new WebResultBuild<String>().code("500").message(WebResultConstant.MSG_INSERT_ERROR).build();
        }
        return new WebResult<String>();
    }

    /**
     * 修改
     * @param userModel
     * @return
     */
    @RequestMapping(method = {RequestMethod.PUT})
    public WebResult<String> update(UserModel userModel){
        try{
            userService.updateAllByModel(userModel);
        }catch (Exception e){
            return new WebResultBuild<String>().code("500").message(WebResultConstant.MSG_INSERT_ERROR).build();
        }
        return new WebResult<String>();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(method = {RequestMethod.DELETE})
    public WebResult<String> delete(@Param("id") Long id){
        try{
            userService.delOrLogicDelById(id);
        }catch (Exception e){
            return new WebResultBuild<String>().code("500").message(WebResultConstant.MSG_INSERT_ERROR).build();
        }
        return new WebResult<String>();
    }




}
