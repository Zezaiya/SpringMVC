package com.zezai.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
//@ComponentScan({"com.zezai.service","com.zezai.dao"})  //通过精准定位到哪些包方式
@ComponentScan(value = "com.zezai",                      //通过排除方式
              excludeFilters = @ComponentScan.Filter(    //使用扫描排除
                      type = FilterType.ANNOTATION,      //通过注解类型排除
                      classes = Controller.class         //注解类型为@Controller
              ))
public class SpringConfig {
}
