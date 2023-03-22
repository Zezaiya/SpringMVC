package com.zezai.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

//Tomcat为我们提供了一个servlet启动容器,在里面加载Spring的配置,需要继承该类↓
public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {   //更简洁
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};                               //只需要我们写上需要被加载的配置类
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter=new CharacterEncodingFilter();   //为我们提供的过滤器类
        filter.setEncoding("UTF-8");                                      //设置过滤类型
        return new Filter[]{filter};
    }
    /* //加载SpringMVC容器            该方法继承的是AbstractDispatcherServletInitializer
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();//获取一个空的IOC容器
        ctx.register(SpringMvcConfig.class);    //通过注册即可获取该配置类的bean,getBean()不能用
         //Tomcat启动后会自动加载它容器里的配置
        return ctx;
    }

    //设置那些请求归springMVC处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};   //表示所有请求交给Spring处理
    }

    //加载spring容器配置
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(SpringConfig.class);     //Tomcat启动后会自动加载IOC容器
        return ctx;
    }*/
}
