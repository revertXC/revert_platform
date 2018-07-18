package com.revert.platform.common.base.mapper;


import com.revert.platform.common.base.model.BaseModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mybatis
 * 基本常用的 增、删、查、改方法
 * @param <T> 实体类
 */
public interface BaseMapper<T extends BaseModel> {

    /**
     * 查询全部数据 通过Model筛选
     * @param t
     * @return
     */
    List<T> selectByModel(T t);

    /**
     * 根据 model ID 查询单个对象
     * @param id
     * @return
     */
    T selectByModelId(@Param("id") Long id);

    /**
     * 根据 model uuid 查询单个对象
     * 暂时不用
     * @param uuid
     * @return
     */
//    T selectByModelUUid(@Param("uuid") String uuid);

    /**
     * 查询总数
     * @return
     */
    int selectAllCount();

    /**
     * 根据条件查询总数
     * @param t
     * @return
     */
    int selectAllCountByModel(T t);

    /**
     * 增加全部值
     * @param t
     * @return
     */
    int insertAll(T t);

    /**
     * 增加非空的值
     * @param t
     * @return
     */
    int insertNotNull(T t);

    /**
     * 根据Id物理删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") Long id);

    /**
     * 根据属性值 物理删除
     * @param t
     * @return
     */
    int deleteByModel(T t);

    /**
     * 根据Id 逻辑删除
     * @param id
     * @return
     */
    int deleteLogicById(@Param("id") Long id);

    /**
     * 根据属性值 逻辑删除
     * @param t
     * @return
     */
    int deleteLogicByModel(T t);

    /**
     * 根据Id 修改值 id 必转
     * @param t
     * @return
     */
    int updateById(T t);

    /**
     * 根据where对象修改新的值
     * @param newObj
     * @param whereObj
     * @return
     */
    int updateByModel(@Param("newObj") T newObj,@Param("whereObj") T whereObj);
}
