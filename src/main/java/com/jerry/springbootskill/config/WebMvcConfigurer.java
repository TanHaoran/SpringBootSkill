package com.jerry.springbootskill.config;

import com.jerry.springbootskill.interceptor.OneInterceptor;
import com.jerry.springbootskill.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 拦截器按照从上往下顺序执行
        // 如果想要拦截所有方法，参数可以传"/*/**"
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**");
        // 下面这样子写可以同时被拦截
        // registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**").addPathPatterns("/one/**");
        super.addInterceptors(registry);
    }
}