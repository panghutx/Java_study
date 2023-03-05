package com.example.demo.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@ResponseBody // 定义返回的数据格式为⾮视图（text/html）
public class UserController {
    //获取配置文件的内容
    @Value("${uploadPath}")
    public String uploadPath;
    @PostConstruct
    public void postConstruct(){
        System.out.println(uploadPath);
    }
    //测试传递对象
    @RequestMapping("/hi")
    public String sayHi(Person person){
        System.out.println(person.getName());
        System.out.println(person.getId());
        System.out.println(person.getPassword());
        return "你好呀"+person.getName();

    }
    //测试参数重命名
    @RequestMapping("/rename")
    public String rename(@RequestParam("rename") String name){
        return name;
    }

    //测试接收json对象
    @ResponseBody
    @RequestMapping(value="/json",method = RequestMethod.POST)
    public Object getJson(@RequestBody Person person){
        System.out.println(person);
        return person;
    }

    //测试获取url中的参数
    @RequestMapping("/url/{name}/{id}")
    public String getParm(@PathVariable String name,@PathVariable Integer id){
        System.out.println(name);
        System.out.println(id);
        return name+" "+id;
    }

    //测试上传文件
    @RequestMapping("/image")
    public String uploadImage(@RequestPart("file") MultipartFile file) throws IOException {
        String path = uploadPath;
        //获取文件名
        String fileName = UUID.randomUUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        file.transferTo(new File(path+fileName));
        return "上传成功";
    }

    //测试获取Cookie
    @RequestMapping("/cookie")
    @ResponseBody
    public String getCookie(@CookieValue("key") String key){
        return key;
    }
}
