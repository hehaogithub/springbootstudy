package com.bootstudy.controller;

import com.bootstudy.Person;
import com.bootstudy.service.RedisService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private RedisService redisService;
    @PostMapping("/index")
    @ParameterNames({"name","age","address"})
    public String index(HttpServletRequest request,String name,String age,String address) throws InterruptedException {
        redisService.lPush("names",name);
        redisService.lPush("ages",age);
        redisService.lPush("address",address);
        return "<h1>Hello Spring Boot 2.x!</h1>";
    }
    @GetMapping("/getPerson")
    public List<Person> getPerson(){
        List<Person> plist=new ArrayList<>();
        Person p;
        for(int i=0;i<4;i++){
            p=new Person("name"+i,"address"+i,"company"+i);
            plist.add(p);

        }
        return plist;

    }
}
