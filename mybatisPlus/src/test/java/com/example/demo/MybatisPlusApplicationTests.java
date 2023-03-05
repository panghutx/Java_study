package com.example.demo;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

	/**
	 * 添加操作
	 */
	@Test
	void addUser(){
		User user = new User();
		user.setAge(20);
		user.setEmail("2367233@qq.com");
		user.setName("panghu");
		user.setId(6L);
		int ret = userMapper.insert(user);
		System.out.println(ret);
	}

	/**
	 * 更新操作
	 */
	@Test
	void updataUser(){
		User user = new User();
		user.setAge(20);
		user.setEmail("2367233@qq.com");
		user.setName("胖虎");
		user.setId(6L);
		int ret = userMapper.updateById(user);
		System.out.println(ret);

	}
	/**
	 * 删除操作
	 */
	@Test
	void deleteById(){
		int ret = userMapper.deleteById(6l);
		System.out.println(ret);
	}

	@Test
	void deleteMap(){
		Map<String,Object> map = new HashMap<>();
		map.put("id",5l);
		map.put("name","Billie");
		int ret = userMapper.deleteByMap(map);
		System.out.println(ret);
	}

	@Test
	void deleteBatch(){
		int ret = userMapper.deleteBatchIds(Arrays.asList(1l,2l,3l));
		System.out.println(ret);
	}

	/**
	 * 查询操作
	 */
	@Test
	void selectAll(){
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

	@Test
	void selectById(){
		User user = userMapper.selectById(1l);
		System.out.println(user);
	}

	@Test
	void selectBatch(){
		List<User> userList = userMapper.selectBatchIds(Arrays.asList(1l, 2l, 3l));
		userList.forEach(System.out::println);
	}

	@Test
	void selectByMap(){
		Map<String,Object> map = new HashMap<>();
		map.put("id",1l);
		List<User> userList = userMapper.selectByMap(map);
		userList.forEach(System.out::println);
	}

	/**
	 * 查询操作(Service接口)
	 */
	@Test
	void selectGetById(){
		User user = userService.getById(1);
		System.out.println(user);
	}

	@Test
	void select(){
		List<User> userList = userService.listByIds(Arrays.asList(1l, 2l, 5l));
		userList.forEach(System.out::println);
	}

}
