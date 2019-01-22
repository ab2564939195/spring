package com.app.ckxz.base.controller;
import com.app.ckxz.util.ReturnResult;

/**
 * 控制层父类
 * @program function-app
 * @description: BaseController
 * @autor: Mr.Zhang
 * @create: 2018-03-31 09:46
 */
public interface BaseController<T> {

    /**
     * 保存单个对象
     * @param json
     * @return
     */
    public ReturnResult save(String json);

    /**
     * 保存多个对象
     * @param json
     * @return
     */
    public ReturnResult saveList(String json);

    /**
     * 根据主键删除对象
     * @param uuid
     * @return
     */
    public ReturnResult delete(String uuid);

    /**
     * 根据对象主键数组删除对象
     * @param uuids
     * @return
     */
    public ReturnResult deletes(String uuids);

    /**
     * 修改单条数据
     * @param json
     * @return
     */
    public ReturnResult update(String json);

    /**
     * 修改多条数据
     * @param json
     * @return
     */
    public ReturnResult updates(String json);

    /**
     * 根据主键获取对象
     * @param uuid
     * @return
     */
    public ReturnResult findById(String uuid);

}
