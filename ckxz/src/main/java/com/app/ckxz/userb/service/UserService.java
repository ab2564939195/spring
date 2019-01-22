package com.app.ckxz.userb.service;

import com.app.ckxz.base.service.BaseService;
import com.app.ckxz.util.ReturnResult;

public interface UserService extends BaseService<String> {
    /**
     * 登录
     * @param json
     * @return
     */
    ReturnResult login(String json);

    /**
     * 用户信息
     * @param json
     * @return
     */
    ReturnResult selectUserAll(String json);

}
