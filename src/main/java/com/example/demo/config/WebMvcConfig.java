package com.example.demo.config;

import com.example.demo.interceptor.BaseInterceptor;
import com.example.demo.mapper.UserMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Resource
    private BaseInterceptor baseInterceptor;

    @Resource
    private UserMapper userMapper;


    /**
     * 配置静态资源
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        baseInterceptor.setUserMapper(userMapper);
        // 添加拦截器，并指定要拦截的路径和排除的路径
        registry.addInterceptor(baseInterceptor).addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/user/login", "/user/register"); // 排除登录页面、错误页面和其他不需要拦截的路径
    }
}