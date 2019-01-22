package cn.bdqn.service;

import cn.bdqn.dao.GradeMapper;
import cn.bdqn.entity.Grade;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/31/031.
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public PageInfo<Grade> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Grade> list=gradeMapper.queryAll();
        return new PageInfo<Grade>(list);
    }

    @Override
    public Grade queryGradeById(Integer id) {
        return gradeMapper.queryGradeById(id);
    }
}
