package com.revert.modue.shiro.user.model;

import com.revert.platform.common.annotation.LogicDelete;
import com.revert.platform.common.base.model.BaseModel;
import lombok.Data;

@Data
@LogicDelete()
public class SysUserModel extends BaseModel {

    /**名称*/
    private String name;

    /**账号*/
    private String account;

    /**密码*/
    private String password;


}
