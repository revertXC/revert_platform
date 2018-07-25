package com.revert.modue.shiro.user.controller;

import com.revert.modue.shiro.user.model.SysUserModel;
import com.revert.modue.shiro.user.service.SysUserService;
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

@Log4j2
@RestController
@RequestMapping("/admin/api/v1/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    /**
     * 分页查询
     * @param userModel
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET})
    public WebResult<BasePageInfo> selectByPage(SysUserModel userModel){
        BasePageInfo basePageInfo = userService.selectByPage(userModel);
        return new WebResultBuild<BasePageInfo>().data(basePageInfo).build();
    }

    /**
     * 查询全部
     * @param userModel
     * @return
     */
    @RequestMapping(value = "all",method = {RequestMethod.GET})
    public WebResult<List<SysUserModel>> selectAll(SysUserModel userModel){
        List<SysUserModel> listUser = userService.selectByModel(userModel);
        return new WebResultBuild<List<SysUserModel>>().data(listUser).build();
    }


    /**
     * 增加
     * @param userModel
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST})
    public WebResult<String> insert(SysUserModel userModel){
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
    public WebResult<String> update(SysUserModel userModel){
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
