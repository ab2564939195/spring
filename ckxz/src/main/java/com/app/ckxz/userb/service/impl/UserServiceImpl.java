package com.app.ckxz.userb.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.ckxz.userb.mapper.UserDMapper;
import com.app.ckxz.userb.moder.UserD;
import com.app.ckxz.userb.service.UserService;
import com.app.ckxz.util.ReturnResult;
import com.app.ckxz.util.StringUtil;
import com.app.ckxz.util.crypt.BCrypt;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDMapper userDMapper;

    @Override
    public ReturnResult insert(String t) {
        return null;
    }

    @Override
    public ReturnResult insertList(String t) {
        return null;
    }

    @Override
    public ReturnResult deleteById(String uuid) {
        ReturnResult returnResult = new ReturnResult();
        if (StringUtil.isEmpty(uuid)) {
            returnResult.setReturnCode(-1);
            returnResult.setMsg("uuid为空");
            return returnResult;
        }
        int i = userDMapper.deleteByUuid(uuid);
        if (i > 0) {
            returnResult.setReturnCode(200);
            returnResult.setMsg("删除成功");
        } else {
            returnResult.setReturnCode(-1);
            returnResult.setMsg("删除失败");
        }
        return returnResult;
    }

    @Override
    public ReturnResult deleteList(String uuid) {
        return null;
    }

    /**
     * 修改用户信息
     *
     * @param t
     * @return
     */
    @Override
    public ReturnResult update(String t){
        ReturnResult returnResult = new ReturnResult();
        if (StringUtil.isEmpty(t)) {
            returnResult.setReturnCode(-1);
            returnResult.setMsg("参数不能为空");
            return returnResult;
        }
        UserD userD = JSON.parseObject(t, UserD.class);
        if (userD == null || StringUtil.isEmpty(userD.getUuid())) {
            returnResult.setReturnCode(-1);
            returnResult.setMsg("参数不能为空");
            return returnResult;
        }
        //查询之前的信息
        UserD beforeUserD = userDMapper.selectByPrimaryKey(userD.getUuid());
        if (beforeUserD == null) {
            returnResult.setReturnCode(-1);
            returnResult.setMsg("用户信息不正确");
            return returnResult;
        }
        Map<String, Object> map = new HashMap<>();
        if (!beforeUserD.getLoginId().equals(userD.getLoginId())) {
            map.put("loginId", userD.getLoginId());
            if (userDMapper.selectUserByUuidOrLoginId(map) != null) {
                map.clear();
                returnResult.setReturnCode(-1);
                returnResult.setMsg(userD.getLoginId() + "该手机号已经存在无法修改");
                return returnResult;
            }
            map.clear();
        }
        if (StringUtil.isNotEmpty(userD.getCardIdNum())) {
            if (!userD.getCardIdNum().equals(beforeUserD.getCardIdNum())) {
                map.put("cardIdNum", userD.getCardIdNum());
                if (userDMapper.selectUserByUuidOrLoginId(map) != null) {
                    map.clear();
                    returnResult.setReturnCode(-1);
                    returnResult.setMsg(userD.getLoginId() + "该身份证已经存在无法修改");
                    return returnResult;
                }
                map.clear();
            }
        }
        if (StringUtil.isNotEmpty(userD.getBankcardNo())) {
            if (!userD.getBankcardNo().equals(beforeUserD.getBankcardNo())) {
                map.put("bankcardNo", userD.getBankcardNo());
                if (userDMapper.selectUserByUuidOrLoginId(map) != null) {
                    map.clear();
                    returnResult.setReturnCode(-1);
                    returnResult.setMsg(userD.getLoginId() + "该银行卡已经存在无法修改");
                    return returnResult;
                }
                map.clear();
            }
        }
        if (userDMapper.updateByPrimaryKey(userD) > 0) {
            returnResult.setReturnCode(200);
            returnResult.setMsg("修改成功");
        } else {
            returnResult.setReturnCode(-1);
            returnResult.setMsg("修改失败");
        }
        return returnResult;
    }

    @Override
    public ReturnResult updateList(String t) {
        return null;
    }

    @Override
    public ReturnResult findById(String uuid) {
        return null;
    }

    @Override
    public ReturnResult findAll() {
        return null;
    }

    /**
     * 登录
     *
     * @param json
     * @return
     */
    @Override
    public ReturnResult login(String json) {
        ReturnResult returnResult = new ReturnResult();
        if (StringUtil.isEmpty(json)) {
            returnResult.setReturnCode(-1);
            returnResult.setMsg("参数不能为空");
            return returnResult;
        }
        Map<String, Object> map = JSON.parseObject(json, Map.class);
        if (map == null || map.get("userName") == null || map.get("password") == null) {
            returnResult.setReturnCode(-1);
            returnResult.setMsg("参数不能为空");
            return returnResult;
        }
        map.put("state", "1");
        UserD login = userDMapper.login(map);
        if (login == null) {
            returnResult.setReturnCode(-1);
            returnResult.setMsg("用户名或者密码错误");
            return returnResult;
        } else {
            if (StringUtil.isEmpty(login.getWuyeUuid())) {
                returnResult.setReturnCode(-1);
                returnResult.setMsg("您没有权限");
                return returnResult;
            }
//            if (!BCrypt.checkpw(map.get("password").toString(), login.getPassword())) {
//                returnResult.setReturnCode(-1);
//                returnResult.setMsg("密码错误");
//                return returnResult;
//            }
        }
        returnResult.setObject(login);
        returnResult.setReturnCode(1);
        returnResult.setMsg("登录成功");
        return returnResult;
    }

    /**
     * 用户信息
     *
     * @param json
     * @return
     */
    @Override
    public ReturnResult selectUserAll(String json) {
        ReturnResult returnResult = new ReturnResult();
        Map<String, Object> map = JSON.parseObject(json, Map.class);
        Page page = null;
        if (!map.isEmpty()) {
            if (map.get("userName") != null) {
                map.put("userName", "%" + map.get("userName") + "%");
            }
            if (map.get("pageSize") != null && map.get("pageNum") != null) {
                page = PageHelper.startPage(Integer.parseInt(map.get("pageNum").toString()), Integer.parseInt(map.get("pageSize").toString()));
            }
        }
        List<UserD> userDS = userDMapper.selectUserAll(map);
        Map<String, Object> maps = new HashMap<>();
        if ((map.get("pageSize") != null && map.get("pageNum") != null)) {
            maps.put("pageSize", page.getPageSize());
            maps.put("pages", page.getTotal());
            maps.put("pageNum", page.getPageNum());
        }
        returnResult.setReturnCode(200);
        returnResult.setObj(userDS);
        returnResult.setMsg("查询成功");
        returnResult.setMap(maps);
        return returnResult;
    }
}
