package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Service实现类
 * 1.继承ServiceImpl，并且在泛型中指定对应的Mapper接口和实体对象
 * 2.实现service接口
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}
