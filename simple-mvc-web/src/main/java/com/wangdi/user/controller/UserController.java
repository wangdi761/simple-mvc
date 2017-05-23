package com.wangdi.user.controller;

import com.wangdi.user.domain.User;
import com.wangdi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

/**
 * Created by D on 2017/5/22.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(String loginname, String password,
                              ModelAndView mv, HttpSession session) {
        User user = userService.login(loginname, password);
        if (user != null) {
            session.setAttribute("user", user);
            mv.setView(new RedirectView("main"));
        } else {
            mv.addObject("message", "登录名或密码错误，请重新输入！");
            mv.setViewName("loginForm");
        }
        return mv;
    }

}
