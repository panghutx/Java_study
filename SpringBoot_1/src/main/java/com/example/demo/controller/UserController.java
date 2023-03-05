package com.example.demo.controller;

import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService list1;

    @PostConstruct
    public void postConstruct(){
        System.out.println(list1);
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String sayHi(String name){

        return "你好呀"+name;

    }



}
