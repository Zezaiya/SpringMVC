package com.zezai.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Spring需要加载我们配置controller里的bean(即servlet),所以需要编写spring配置类
@Configuration
@EnableWebMvc
@ComponentScan("com.zezai.controller")
public class SpringMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //使用默认的servlet访问静态资源
        configurer.enable();
    }

    
}
