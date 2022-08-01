package cn.youngsay.mybatis.mapper;

import cn.youngsay.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    int insertUser();
    int deleteUser();
    User selectById(Integer userId);
    List<User> selectAll();

    /**
     * 添加用户
     */
    void insertUser1(User user);
}
