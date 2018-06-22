package com.demo.config;

import com.demo.controller.User1Controller;
import com.demo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Administrator on 2018/5/30.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/user1/test3")
//        .excludePathPatterns("/user/*");  //user下所有模块过不拦截

        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user1/*");
    }
}
