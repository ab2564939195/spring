package com.app.ckxz.wuyeemployee.contraller;

import com.app.ckxz.base.service.BaseService;
import com.app.ckxz.util.ReturnResult;
import com.app.ckxz.wuyeemployee.service.WuyeEmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/wuyeEmployee")
public class WuyeEmployeeContaller implements BaseService<String> {
    @Resource
    private WuyeEmployeeService wuyeEmployeeService;
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
    @PostMapping ("/wuyeEmployeeCondition")
    public ReturnResult selectWuyeEmployeeCondition( String json) {
        return wuyeEmployeeService.selectWuyeEmployeeCondition(json);
    }
}
