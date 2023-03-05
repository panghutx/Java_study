package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.pojo.User;
import com.example.demo.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusApplicationTests1 {

    @Autowired
    private UserService userService;

    /**
     * 条件查询
     * gt大于  lt小于  eq等于  ge大于等于  le小于等于
     */
    @Test
    void select(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","o")
                .ge("age",18);
        List<User> userList = userService.list(queryWrapper);
        System.out.println(userList);
    }

    /**
     * 排序
     * desc 降序排列
     * asc 升序排列
     */
    @Test
    void selectOrderByDesc(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age");
        List<User> userList = userService.list(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 组合条件查询
     */
    @Test
    void selectByMulCondition(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.and((item)->{
            item.like("name","o")
                    .lt("age",21);
        }).or((item)->{
            item.isNotNull("email");
        });
        List<User> userList = userService.list(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 更新updataWrapper
     */
    @Test
    void updata(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("name","panghu").set("age",20).eq("name","Tom");
        userService.update(wrapper);
    }

    /**
     * 动态查询
     */
    @Test
    void selectDynamic(){
        String name = "123";
        Integer age=20;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank("name"),"name",name)
                .eq(age!=null,"age",age);
        List<User> users = userService.list(wrapper);
        users.forEach(System.out::println);
    }
}
