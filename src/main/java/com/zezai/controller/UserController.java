package com.zezai.controller;

import com.zezai.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller   //表示将这个类设置为Bean类(@Component针对普通类,SpringMVC开发专用类用@Controller)
@RequestMapping("/UserController")
public class UserController {
    @RequestMapping("/save")   //设置该servlet的访问路径                !!!!注意,这两个注解一定要写在方法上面!!!!!!
    @ResponseBody  //设置返回体,方法返回的内容会通过这个标签传给浏览器
    public String save(){
        System.out.println("save...");
        return "{'module':'UserController'}";
    };

    @RequestMapping("/set")
    @ResponseBody
    public String set(@RequestParam("name") String username){  //通过该注解即可将name参数传入username里
        System.out.println("username的值为:"+username);
        return "{'module':'name->username'}";
    };

    @RequestMapping("/ArrayTest")
    @ResponseBody
    public String ArrayTest(String[] likes){
        for (int i = 0; i < likes.length; i++) {
            System.out.println(likes[i]);
        }
        return "{'module':'ArrayTest'}";
    }

    @RequestMapping("/ListTest")
    @ResponseBody
    public String ListTest(@RequestParam List<String> lists){
            System.out.println(lists);
        return "{'module':'ListTest'}";
    }


    @RequestMapping("/UserTest")
    @ResponseBody
    public String UserTest(User user){
        System.out.println("id="+user.getId());
        System.out.println("name="+user.getName());
        System.out.println("username="+user.getUsername());
        System.out.println("password="+user.getPassword());
        System.out.println("age="+user.getAge());
        return "{'module':'UserTest'}";
    }


    @RequestMapping("/JsonTest1")
    @ResponseBody
    public String JsonTest1(@RequestBody String[] likes){
        for (int i = 0; i < likes.length; i++) {
            System.out.println(likes[i]);
        }
        return "{'module':'JsonTest1'}";
    }



    @RequestMapping("/JsonTest2")
    @ResponseBody
    public String JsonTest2(@RequestBody User user){
        System.out.println(user);
        return "{'module':'JsonTest2'}";
    }


    @RequestMapping("/JsonTest3")
    @ResponseBody
    public Date JsonTest3(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){  //默认为斜线
        System.out.println(date);
        return date ;
    }

}
