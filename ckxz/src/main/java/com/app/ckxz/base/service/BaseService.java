package com.app.ckxz.base.service;

import com.app.ckxz.util.ReturnResult;

import java.text.ParseException;

/**
 *  service接口父类
 * @param <ET> 主键类型
 */
public interface BaseService<ET> {

    /**
     * 单条数据保存
     * @param t
     * @return
     */
    public ReturnResult insert(String t);

    /**
     * 多条数据保存
     * @param t
     * @return
     */
    public ReturnResult insertList(String t);

    /**
     * 根据ID删除
     * @param uuid
     * @return
     */
    public ReturnResult deleteById(ET uuid);

    /**
     * 根据uuid集合批量删除
     * @param uuid
     * @return
     */
    public ReturnResult deleteList(ET uuid);

    /**
     * 修改数据
     * @param t
     * @return
     */
    public ReturnResult update(String t);

    /**
     * 批量修改实体
     * @param t
     * @return
     */
    public ReturnResult updateList(String t);

    /**
     * 根据ID获取实体
     * @param uuid
     * @return
     */
    public ReturnResult findById(ET uuid);

    /**
     * 获取所有数据
     * @return
     */
    public ReturnResult findAll();
}
