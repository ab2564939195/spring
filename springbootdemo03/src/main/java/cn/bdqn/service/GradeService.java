package cn.bdqn.service;

import cn.bdqn.entity.Grade;
import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2018/3/31/031.
 */
public interface GradeService {
    public PageInfo<Grade> queryAll(Integer pageNum,Integer pageSize);

    public Grade queryGradeById(Integer id);
}
