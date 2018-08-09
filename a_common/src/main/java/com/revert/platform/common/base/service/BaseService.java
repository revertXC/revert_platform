package com.revert.platform.common.base.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.revert.platform.common.annotation.LogicDelete;
import com.revert.platform.common.base.mapper.BaseMapper;
import com.revert.platform.common.base.model.BaseModel;
import com.revert.platform.common.base.model.BasePageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Log4j2
public class BaseService<T extends BaseModel,M extends BaseMapper<T>>{

    @Autowired
    protected M mapper;

    public BasePageInfo selectByPage(T t){
        PageHelper.startPage(t.getPageNum(), t.getPageSize(), t.getOrderBy());
        List<T> listObj = this.selectByModel(t);
        PageInfo<T> pageInfo = new PageInfo<>(listObj);

        BasePageInfo basePageInfo = new BasePageInfo();
        basePageInfo.setData(pageInfo.getList());
        basePageInfo.setPageNum(pageInfo.getPageNum());
        basePageInfo.setPageSize(pageInfo.getPageSize());
        basePageInfo.setTotal(pageInfo.getTotal());
        basePageInfo.setTotalNum(pageInfo.getPages());
        return basePageInfo;
    }

    /**
     * 逻辑删除 或者 物理删除
     * @param id
     * @return
     */
    public int delOrLogicDelById(Long id){
        try {
            /**获取当前调用对象的Class*/
            Class clazz = this.getClass();
            LogicDelete logicDelete = (LogicDelete) clazz.getAnnotation(LogicDelete.class);
            /**如果是逻辑删除*/
            if(logicDelete.value()){
                return this.deleteLogicById(id);
            }
        } catch (Exception e) {
            //异常不处理
        }
        return this.deleteById(id);
    }

    /**
     * 逻辑删除 或者 物理删除
     * @param t)
     * @return
     */
    public int delOrLogicDelByModel(T t){
        try {
            /**获取当前调用对象的Class*/
            Class clazz = this.getClass();
            LogicDelete logicDelete = (LogicDelete) clazz.getAnnotation(LogicDelete.class);
            /**如果是逻辑删除*/
            if(logicDelete.value()){
                return this.mapper.deleteLogicByModel(t);
            }
        } catch (Exception e) {
//            return this.deleteByModel(t);
        }
        return this.deleteByModel(t);
    }





















    /******************** 基础service 无逻辑*******************************************************************/
    public List<T> selectByModel(T t) {
        return this.mapper.selectByModel(t);
    }

    public T selectByModelId(Long id) {
        return this.mapper.selectByModelId(id);
    }


    public int selectAllCount() {
        return this.mapper.selectAllCountByModel(null);
    }

    public int selectAllCountByModel(T t) {
        return this.mapper.selectAllCountByModel(t);
    }

    public int insertAll(T t) {
        return this.mapper.insertAll(t);
    }

    public int insertNotNull(T t) {
        return this.mapper.insertNotNull(t);
    }

    public int deleteById(Long id) {
        return this.mapper.deleteById(id);
    }

    public int deleteByModel(T t) {
        return this.mapper.deleteByModel(t);
    }

    public int deleteLogicById(Long id) {
        return this.mapper.deleteLogicById(id);
    }

    public int deleteLogicByModel(T t) {
        return this.mapper.deleteLogicByModel(t);
    }

    public int updateById(T t) {
        return this.mapper.updateById(t);
    }

    public int updateByModel(T newObj, T whereObj) {
        return this.mapper.updateByModel(newObj, whereObj);
    }

    public int updateAllByModel(T t) {
        return this.mapper.updateAllByModel(t);
    }
}
