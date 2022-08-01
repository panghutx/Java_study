package cn.youngsay.mybatis.mapper;

import cn.youngsay.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 条件查询
     * @param user
     * @return
     */
    public List<User> selectUser(User user);
}
