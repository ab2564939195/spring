package cn.bdqn.dao;

import cn.bdqn.entity.Grade;

import java.util.List;

/**
 * Created by Administrator on 2018/3/31/031.
 */
public interface GradeMapper {

    public List<Grade> queryAll();

    public Grade queryGradeById(Integer id);
}
