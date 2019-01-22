package com.app.ckxz.company.controller;

import com.app.ckxz.base.controller.BaseController;
import com.app.ckxz.company.moder.Company;
import com.app.ckxz.company.service.CompanyService;
import com.app.ckxz.company.service.impl.CompanyServiceImpl;
import com.app.ckxz.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/company")
public class CompanyContaller implements BaseController<Company> {
    @Resource
    private CompanyService companyService;
    /**
     * 删除重复的公司管理人
     * @return
     */
    @DeleteMapping ("/deleteAllCustodian")
    public String deleteCompanyRepetitionCustodian(){
        return companyService.deleteCompanyRepetitionCustodian();
    }

    @Override
    public ReturnResult save(String toJson) {
        return null;
    }

    @Override
    public ReturnResult saveList(String toJson) {
        ReturnResult returnResult = new ReturnResult();
        return null;
    }

    @Override
    public ReturnResult delete(String uuid) {
        return null;
    }

    @Override
    public ReturnResult deletes(String uuids) {
        return null;
    }

    @Override
    public ReturnResult update(String toJson) {
        return null;
    }

    @Override
    public ReturnResult updates(String toJson) {
        return null;
    }

    @Override
    public ReturnResult findById(String uuid) {
        return null;
    }
}
