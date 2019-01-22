package cn.bdqn.controller;

import cn.bdqn.entity.Grade;
import cn.bdqn.service.GradeService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/3/31/031.
 */
@Controller
@RequestMapping("grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @RequestMapping(value = "queryAll",method = RequestMethod.GET,
    produces = {"application/json;charset=utf-8"})
    public String queryAll(Integer pageNum, Integer pageSize, Model model){
        PageInfo<Grade> pageInfo = gradeService.queryAll(pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "grade";
    }

    @ResponseBody
    @RequestMapping(value = "queryGradeById",method = RequestMethod.GET,
    produces = {"application/json;charset=utf-8"})
    public String queryGradeById(Integer gradeId){
        Grade grade = gradeService.queryGradeById(gradeId);
        return JSON.toJSONString(grade);
    }
}
