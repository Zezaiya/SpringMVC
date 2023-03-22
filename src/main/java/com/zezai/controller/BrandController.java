package com.zezai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/BrandController")
public class BrandController {
    @RequestMapping("/save")                //如果想要和UserController里的路径同名,只需要加上该模块名即可
    @ResponseBody
    public String save(){
        System.out.println("save...");
        return "{'module':'BrandController'}";
    };

    @RequestMapping("/set")
    @ResponseBody
    public String set(String name,int age){    //若需要接收get请求的参数,只需要在该servlet方法填上参数名
        System.out.println("get/Post方式获取的普通参数一:"+name);
        System.out.println("get/Post方式获取的普通参数二:"+age);
        return name;
    }
}
