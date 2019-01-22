package com.app.ckxz.wuyeemployee.service;

import com.app.ckxz.base.service.BaseService;
import com.app.ckxz.util.ReturnResult;
import com.app.ckxz.wuyeemployee.moder.WuyeEmployee;

import java.util.List;
import java.util.Map;

public interface WuyeEmployeeService extends BaseService<String> {
    ReturnResult selectWuyeEmployeeCondition(String json);
}
