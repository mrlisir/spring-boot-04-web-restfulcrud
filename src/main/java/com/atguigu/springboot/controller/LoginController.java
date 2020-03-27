package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    //@RequestMapping(value = "/user_login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){


        if(!StringUtils.isEmpty(username) && password.equals("123456")){
            session.setAttribute("loginUser",username);
            //登录成功  为了方式表单重复提交 可以重定向
            return "redirect:/main.html";
        }
        else {
            //登录失败
            map.put("msg","登录失败,用户名密码错误");
            return "login";
        }
    }

}
