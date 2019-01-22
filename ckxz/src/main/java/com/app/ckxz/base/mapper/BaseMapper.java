package com.app.ckxz.base.mapper;

import java.util.List;

public interface BaseMapper<T,ET> {
    /**
     * 根据uuid删除
     * @param uuid
     * @return
     */
    int deleteByPrimaryKey(ET uuid);

    /**
     * 保存对象
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 根据uuid查看
     * @param uuid
     * @return
     */
    T selectByPrimaryKey(ET uuid);

    /**
     * 查询所有
     * @return
     */
    List<T> selectAll();
    /**
     * 根据主键修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);
}
