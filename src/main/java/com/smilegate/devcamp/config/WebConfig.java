package com.smilegate.devcamp.config;

import com.smilegate.devcamp.interceptor.LogInCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LogInCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/devcamp", "/devcamp/login", "/devcamp/register", "devcamp/logout"
                ,"/css/**","/js/**", "/*.ico", "/error");
    }
}
