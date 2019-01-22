package cn.bdqn.controller;

import cn.bdqn.entity.Tuser;
import cn.bdqn.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/3/28/028.
 */
@Controller
public class UserController {

    @Autowired
    private TuserService tuserService;

    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(Tuser tuser, HttpSession session, Model model) {
        Tuser loginUser=tuserService.login(tuser);
        if (null != loginUser) {
            session.setAttribute("loginUser",loginUser);
            return "welcome";
            //登录成功
        }
        //登录失败
        model.addAttribute("msg","用户名密码错误");
        return "login";
    }
}
