package com.atguigu.springboot.config;

//import com.atguigu.springboot.compoent.LoginHandlerIntercceptor;
//import com.atguigu.springboot.compoent.LoginHandlerIntercceptor;
import com.atguigu.springboot.compoent.LoginHandlerIntercceptor;
import com.atguigu.springboot.compoent.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


//@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

  /*  @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        //静态资源 css，js
        //spring boot 已经做好了静态资源的拦截器映射
        registry.addInterceptor(new LoginHandlerIntercceptor()).addPathPatterns("/**")
            .excludePathPatterns("/index.html","/","/user/login","/static");
    }*/
/*----------------------------------生效的--------------------------*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("拦截器进入");
        registry.addInterceptor(new LoginHandlerIntercceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
    }

    /*----------------------------------生效的--------------------------*/


    public void addViewControllers(ViewControllerRegistry registry){
            registry.addViewController("atguigu").setViewName("success");
            registry.addViewController("/").setViewName("login");
        registry.addViewController("index.html").setViewName("login");
            registry.addViewController("login.html").setViewName("login");
            registry.addViewController("main.html").setViewName("dashboard");


        }

   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }*/


    @Bean
        public LocaleResolver localeResolver(){
                return new MyLocaleResolver();
        }


}
