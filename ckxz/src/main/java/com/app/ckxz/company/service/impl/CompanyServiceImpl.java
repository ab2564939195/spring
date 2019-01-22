package com.app.ckxz.company.service.impl;

import com.alibaba.fastjson.JSON;
import com.app.ckxz.company.mapper.CompanyEmployeeMapper;
import com.app.ckxz.company.mapper.CompanyMapper;
import com.app.ckxz.company.moder.CompanyEmployee;
import com.app.ckxz.company.service.CompanyService;
import com.app.ckxz.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private CompanyEmployeeMapper companyEmployeeMapper;
    /**
     * 删除重复的公司管理人
     * @return
     */
    @Override
    @Transactional(rollbackFor = Error.class)
    public String deleteCompanyRepetitionCustodian() {
        // 1 1 2 2 4 3 3
        List<CompanyEmployee> companyEmployeeAcount = companyEmployeeMapper.isCompanyEmployeeAcount();
        String companyId = "";
        boolean bool  = true;
        List<String> list = null;
        int count = 0;
        if(companyEmployeeAcount!= null && !companyEmployeeAcount.isEmpty()){
            for (CompanyEmployee companyEmployee : companyEmployeeAcount) {
                if(bool){
                    companyId =companyEmployee.getCompanyUuid();
                    bool = false;
                }else{
                    if(companyId.equals(companyEmployee.getCompanyUuid())){
                        if(list == null){
                            list = new ArrayList<>();
                        }
                        list.add(companyEmployee.getId().toString());

                    }else{
                        companyId =companyEmployee.getCompanyUuid();
                    }
                }
            }
            if(list!= null && !list.isEmpty()){
                count = companyEmployeeMapper.deleteByListId(list);
                list.clear();
                companyEmployeeAcount.clear();
            }
        }
        if(count>0){
            return "成功";
        }else{
            return "失败";
        }
    }

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
}
