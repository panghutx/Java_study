package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Calculation {

    @ResponseBody
    @RequestMapping("/cal")
    public String calculate(Integer num1, Integer num2){

        int ret=num1+num2;
        System.out.println(ret);
        return "结果为"+ret;
    }
}
