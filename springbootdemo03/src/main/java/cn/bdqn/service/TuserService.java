package cn.bdqn.service;

import cn.bdqn.entity.Tuser;
import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2018/3/28/028.
 */
public interface TuserService {
    Tuser login(Tuser tuser);

    public PageInfo<Tuser> queryAll(Integer pageNum, Integer pageSize);
}
