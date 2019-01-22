package cn.bdqn.dao;

import cn.bdqn.entity.Tuser;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28/028.
 */
public interface TuserMapper {

    Tuser login(Tuser tuser);

    public List<Tuser> queryAll();
}
