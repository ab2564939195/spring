package cn.bdqn.service;

import cn.bdqn.dao.TuserMapper;
import cn.bdqn.entity.Tuser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28/028.
 */
@Service
public class TuserServiceImpl implements TuserService {

    @Autowired
    private TuserMapper tuserMapper;

    @Override
    public Tuser login(Tuser tuser) {
        return tuserMapper.login(tuser);
    }

    @Override
    public PageInfo<Tuser> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Tuser> list=tuserMapper.queryAll();
        return new PageInfo<Tuser>(list);
    }
}
