package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("mp_user") //对应数据库的表名
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

