package com.app.ckxz.wuyeemployee.service.impl;

import com.alibaba.fastjson.JSON;
import com.app.ckxz.util.ReturnResult;
import com.app.ckxz.util.StringUtil;
import com.app.ckxz.wuyeemployee.mapper.WuyeEmployeeMapper;
import com.app.ckxz.wuyeemployee.moder.WuyeEmployee;
import com.app.ckxz.wuyeemployee.service.WuyeEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class WuyeEmployeeServiceImpl implements WuyeEmployeeService {
    @Resource
    private WuyeEmployeeMapper wuyeEmployeeMapper;
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
        return null;
    }

    @Override
    public ReturnResult deleteList(String uuid) {
        return null;
    }

    @Override
    public ReturnResult update(String t) {
        return null;
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
     * 查询物业员工 在职和离职
     * @param json
     * @return
     */
    @Override
    public ReturnResult selectWuyeEmployeeCondition(String json) {
        ReturnResult returnResult = new ReturnResult();
        if (json == null || "".equals(json)){
            returnResult.setReturnCode(-1);
            returnResult.setMsg("参数不能正确");
            return returnResult;
        }
        Map<String,Object> map = JSON.parseObject(json,Map.class);
        if (map == null || map.get("wuyeUuid")==null || map.get("state")==null ){
            returnResult.setReturnCode(-1);
            returnResult.setMsg("参数不全");
            return returnResult;
        }
        List<WuyeEmployee> wuyeEmployees = wuyeEmployeeMapper.selectWuyeEmployeeCondition(map);
        returnResult.setMsg("查询成功");
        returnResult.setReturnCode(1);
        returnResult.setObj(wuyeEmployees);
        return returnResult;
    }
}
