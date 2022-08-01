package cn.youngsay.mybatis.mapper;

import cn.youngsay.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 查询数据库内的所有信息
     * @return
     */
    @MapKey("userId")
    public Map<String,Object> selectAll();

    /**
     * 模糊查询
     * @param str
     * @return
     */
    public List<User> selectVague(String str);

    /**
     * 批量删除
     * @param str
     */
    public void delete(@Param("str") String str);

    /**
     * 获取自增主键
     */
    public void insetUser(User user);
}
