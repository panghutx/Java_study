import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 添加用户
     */
    public int addUser(User user);

    /**
     * 根据id查找用户
     * @param userId
     * @return
     */
    public User selectById(Integer userId);

    /**
     * 查找所有用户
     * @return
     */
    public List<User> selectAll();

    /**
     * 以map形式返回查找到的用户
     * @return
     */
    @MapKey("userId")
    public Map<Integer,Object> selectByCondition();

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    public List<User> selectVague(@Param("username") String username);

    /**
     * 根据userID批量删除用户
     * @param userID
     */
    public void deleteByCondition(@Param("id") String userID);
}
