package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;

@Controller
public class Login {
    @ResponseBody
    @RequestMapping("/login")
    public Object login(String username,String password){
        HashMap<String,Object> result = new HashMap<>();
        result.put("succ",200);
        if(!username.equals("admin")||!password.equals("1234")){
            result.put("msg","用户名或密码错误，请重新登陆");
        }else{
            result.put("msg","登录成功");
        }
        return result;
    }
}
