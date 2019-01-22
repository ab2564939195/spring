package com.app.ckxz.company.service;

import com.app.ckxz.base.service.BaseService;

public interface CompanyService extends BaseService<String> {
    /**
     * 删除重复的公司管理人
     * @return
     */
    String deleteCompanyRepetitionCustodian();

}
