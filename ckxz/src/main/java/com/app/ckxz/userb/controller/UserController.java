package com.app.ckxz.userb.controller;

import com.app.ckxz.base.controller.BaseController;
import com.app.ckxz.userb.moder.UserD;
import com.app.ckxz.userb.service.UserService;
import com.app.ckxz.util.ReturnResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController implements BaseController<UserD> {
    @Resource
    private UserService userService;
    @Override
    public ReturnResult save(String json) {
        return null;
    }

    @Override
    public ReturnResult saveList(String json) {
        return null;
    }
    @DeleteMapping("/delete/{uuid}")
    @Override
    public ReturnResult delete(@PathVariable("uuid") String uuid) {
        return userService.deleteById(uuid);
    }

    @Override
    public ReturnResult deletes(String uuids) {
        return null;
    }
    @PostMapping("/update")
    @Override
    public ReturnResult update(String json) {
        return userService.update(json);
    }

    @Override
    public ReturnResult updates(String json) {
        return null;
    }

    @Override
    public ReturnResult findById(String uuid) {
        return null;
    }
    /**
     * 登录
     * @param json
     * @return
     */
    @PostMapping("/login")
    public ReturnResult login(String json){
        return userService.login(json);
    }

    /**
     * 查询用户信息
     * @param json
     * @return
     */
    @PostMapping("/all")
    public ReturnResult selectUserAll(String json){
        return userService.selectUserAll(json);
    }
}
