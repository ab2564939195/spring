package cn.bdqn.service;

import cn.bdqn.entity.Grade;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/3/31/031.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeServiceImplTest {
    @Test
    public void queryGradeById() throws Exception {
        Grade grade=gradeService.queryGradeById(99);
        if (null != grade) {
            System.out.println(grade);
        }
    }


    @Autowired
    private GradeService gradeService;
    @Test
    public void queryAll() throws Exception {

        PageInfo<Grade> pageInfo=gradeService.queryAll(1,5);
        if (null != pageInfo) {
            List<Grade> list=pageInfo.getList();
            if (null != list) {
                for (Grade grade : list) {
                    System.out.println(grade);
                }
            }
        }
    }

}