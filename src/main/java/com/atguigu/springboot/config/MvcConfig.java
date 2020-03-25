package com.atguigu.springboot.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


//@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {
        public void addViewControllers(ViewControllerRegistry registry){
            registry.addViewController("atguigu").setViewName("success");
            registry.addViewController("/").setViewName("login");
            registry.addViewController("login.html").setViewName("login");
        }


}
