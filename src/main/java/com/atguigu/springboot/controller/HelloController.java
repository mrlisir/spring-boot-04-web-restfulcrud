package com.atguigu.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController  {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "你好么？？？";
    }

   /* @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }*/


    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("user", Arrays.asList("李明锋","林智荣","谭青青"));
        return "success";
    }
}
