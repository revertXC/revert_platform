package com.revert.modue.shiro.user.service;

import com.revert.modue.shiro.user.mapper.UserMapper;
import com.revert.modue.shiro.user.model.UserModel;
import com.revert.platform.common.base.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserModel, UserMapper> {
}
