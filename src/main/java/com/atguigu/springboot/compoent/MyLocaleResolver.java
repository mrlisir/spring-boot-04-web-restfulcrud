package com.atguigu.springboot.compoent;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/*
* 可以再链接上携带区域信息
* */
public  class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale=null;
        locale=locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
             locale = new Locale(split[0], split[1]);//拿到split 的第一个值[0] 代表语言语言代码,[1] 代表国家代码
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
