package com.app.ckxz.userb.mapper;

import com.app.ckxz.base.mapper.BaseMapper;
import com.app.ckxz.userb.moder.UserD;
import java.util.List;
import java.util.Map;

public interface UserDMapper extends BaseMapper<UserD,String> {

    int deleteByPrimaryKey(Long id);
    int deleteByUuid(String uuid);
    UserD selectByPrimaryKey(String uuid);

    /**
     * 登陆
     * @param map
     * @return
     */
    UserD login(Map<String,Object> map);
    /**
     * 查询用户信息
    * @author fan
    * @date 2019/1/2 19:07
    * @param [map]
    * @return java.util.List<com.app.ckxz.userb.moder.UserD>
    */
    List<UserD> selectUserAll(Map<String , Object> map);

    /**
     * 查询用户信息根据uuid或者手机号
     * @param map
     * @return
     */
    UserD selectUserByUuidOrLoginId(Map<String , Object> map);
}