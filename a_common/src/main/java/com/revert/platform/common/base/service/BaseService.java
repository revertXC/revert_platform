package com.revert.platform.common.base.service;

import com.revert.platform.common.base.mapper.BaseMapper;
import com.revert.platform.common.base.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<T extends BaseModel,M extends BaseMapper<T>> implements BaseMapper<T> {

    @Autowired
    protected M mapper;



























    /******************** 基础service 无逻辑*******************************************************************/
    @Override
    public List<T> selectByModel(T t) {
        return this.mapper.selectByModel(t);
    }

    @Override
    public T selectByModelId(Long id) {
        return this.mapper.selectByModelId(id);
    }

    @Override
    public int selectAllCount() {
        return this.mapper.selectAllCount();
    }

    @Override
    public int selectAllCountByModel(T t) {
        return this.mapper.selectAllCountByModel(t);
    }

    @Override
    public int insertAll(T t) {
        return this.mapper.insertAll(t);
    }

    @Override
    public int insertNotNull(T t) {
        return this.mapper.insertNotNull(t);
    }

    @Override
    public int deleteById(Long id) {
        return this.mapper.deleteById(id);
    }

    @Override
    public int deleteByModel(T t) {
        return this.mapper.deleteByModel(t);
    }

    @Override
    public int deleteLogicById(Long id) {
        return this.mapper.deleteLogicById(id);
    }

    @Override
    public int deleteLogicByModel(T t) {
        return this.mapper.deleteLogicByModel(t);
    }

    @Override
    public int updateById(T t) {
        return this.mapper.updateById(t);
    }

    @Override
    public int updateByModel(T newObj, T whereObj) {
        return this.mapper.updateByModel(newObj, whereObj);
    }
}
