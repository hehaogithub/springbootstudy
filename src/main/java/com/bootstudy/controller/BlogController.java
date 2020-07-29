package com.bootstudy.controller;

import com.bootstudy.modal.Blog;
import com.bootstudy.service.BlogService;
import com.bootstudy.service.RedisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.PersonService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController
public class BlogController {
    @Autowired
    private RedisService redisService;
    @Autowired
    PersonService personService;
    @Autowired
    BlogService blogService;
    @PostMapping("/index")
    @ParameterNames({"name","age","address"})
    public String index(HttpServletRequest request, String name, String age, String address) throws InterruptedException {
        redisService.lPush("names",name);
        redisService.lPush("ages",age);
        redisService.lPush("address",address);
        return "<h1>Hello Spring Boot 2.x!</h1>";
    }

    /*@GetMapping("/getPerson")
    public List<Person> getPerson(){
        List<Person> plist=new ArrayList<>();
        Person p;
        for(int i=0;i<4;i++){
            p=new Person("name"+i,"address"+i,"company"+i);
            plist.add(p);
        }
        return plist;
    }*/
    @GetMapping("/testDemo")
    public void getDemo() {


        personService.sayHello();
    }
    @GetMapping("/login")
    public HashMap<String,Object> login(@RequestParam String username, @RequestParam String password){
        HashMap<String,Object> ret=new HashMap<>();
        if("admin".equals(username)&&"123456".equals(password)){
            ret.put("success",true);
            ret.put("message","验证通过");
        }else{
            ret.put("success",false);
            ret.put("message","验证失败，用户名或密码错误");
        }
       return ret;
    }

    @GetMapping("/getBlog")
    public Map<String,Object> getBlog(@RequestParam Integer id){
        return blogService.getBlog(id);
    }
    @PostMapping("/getBlogList")
    public PageInfo<Blog> getBlog(@RequestBody Map<String, Object> dto){
        PageHelper.startPage((Integer)dto.get("pageNum"),(Integer)dto.get("pageSize"));
        List<Blog> blogList=blogService.getBlogList(dto);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogList);
        return pageInfo;
    }
    @PostMapping("/saveBlog")
    public Map<String,Object> saveBlog(@RequestBody Map<String, Object> dto){
        Map<String,Object> ret=new HashMap<>();
        ret.put("success",true);
        ret.put("msg","保存成功");
        try {
            blogService.saveBlog(dto);
        }catch(Exception e){
            ret.put("success",false);
            ret.put("msg",e.getMessage());

        }
        return ret;
    }
    @PostMapping("/deleteBlog")
    public Map<String,Object> deleteBlog(@RequestBody Map<String, Object> dto){
        Map<String,Object> ret=new HashMap<>();
        ret.put("success",true);
        ret.put("msg","删除成功");
        try {
            blogService.deleteBlog(dto);
        }catch(Exception e){
            ret.put("success",false);
            ret.put("msg",e.getMessage());

        }
        return ret;
    }




}
