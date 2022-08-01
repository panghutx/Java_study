package com.example.demo.controllor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class test {
    @RequestMapping("/hi")
    @ResponseBody
    public String sayHi(String name){
        return "hello123333"+name;
    }
}
