package com.app.ckxz.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnResult<T> {
    /**
     * 返回信息结果标识布尔值
     */
    private boolean flag;

    /**
     * 返回消息提示
     */
    private String msg;

    /**
     * 需转换json对象集合
     */
    private List<T> obj = new ArrayList<T>();

    /**
     * Map集合返回
     */
    private Map map;

    /**
     * 单个对象
     */
    private Object object;

    /**
     * 返回码
     */
    private Integer returnCode;

    /**
     * 默认值为false
     */
    public ReturnResult() {
        this.flag = false;
        this.msg = "fail";
    }

    /**
     * 返回成功方法
     * @param msg
     * @return
     */
    public ReturnResult<T> success(String msg){
        this.flag = true;
        this.msg = msg==null?"success": "".equals(msg) ? "success" : msg ;
        return this;
    }

    /**
     * 需转换json对象集合
     * @return
     */
    public List<T> getObj() {
        return obj;
    }

    /**
     * 需转换json对象集合
     * @param obj
     */
    public void setObj(List<T> obj) {
        this.obj = obj;
    }

    /**
     * Map集合返回
     * @return
     */
    public Map getMap() {
        return map;
    }

    /**
     * Map集合返回
     * @param map
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * 单个对象
     * @return
     */
    public Object getObject() {
        return object;
    }

    /**
     * 单个对象
     * @param object
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * 返回信息结果标识布尔值
     * @return
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * 返回信息结果标识布尔值
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 返回消息提示
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     *  返回消息提示
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }
}
