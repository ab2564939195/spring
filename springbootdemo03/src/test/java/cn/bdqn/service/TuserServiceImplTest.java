package cn.bdqn.service;

import cn.bdqn.entity.Tuser;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28/028.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TuserServiceImplTest {
    @Test
    public void queryAll() throws Exception {
        PageInfo<Tuser> pageInfo=tuserService.queryAll(1,5);
        System.out.println(pageInfo);
        List<Tuser> list=pageInfo.getList();
        if (null != list) {
            for (Tuser tuser : list) {
                System.out.println(tuser);
            }
        }
    }

    @Autowired
    private TuserService tuserService;

    @Test
    public void login() throws Exception {
        Tuser tuser=new Tuser();
        tuser.setUserName("admin");
        tuser.setPassword("abc");
        Tuser loginUser = tuserService.login(tuser);
        if (loginUser != null) {
            System.out.println(loginUser);
        }
    }

}