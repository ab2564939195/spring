package com.app.ckxz.department.controller;

import com.app.ckxz.base.controller.BaseController;
import com.app.ckxz.department.moder.WuyeDepartment;
import com.app.ckxz.department.service.WuyeDepartmentService;
import com.app.ckxz.util.ReturnResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/wuyeDepartment")
public class WuyeDepartmentController implements BaseController<WuyeDepartment> {
    @Resource
    private WuyeDepartmentService wuyeDepartmentService;
    @PostMapping("/save")
    @Override
    public ReturnResult save(String toJson) {
        return  wuyeDepartmentService.insert(toJson);
    }

    @Override
    public ReturnResult saveList(String toJson) {
        return null;
    }
    @DeleteMapping("/delete/{uuid}")
    @Override
    public ReturnResult delete(@PathVariable("uuid") String uuid) {
        return wuyeDepartmentService.deleteById(uuid);
    }

    @Override
    public ReturnResult deletes(String uuids) {
        return null;
    }
    @PutMapping("/update")
    @Override
    public ReturnResult update(String toJson) {
        return wuyeDepartmentService.update(toJson);
    }

    @Override
    public ReturnResult updates(String toJson) {
        return null;
    }
    @GetMapping("/findById")
    @Override
    public ReturnResult findById(String uuid) {
        return wuyeDepartmentService.findById(uuid);
    }
}
