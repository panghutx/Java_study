import cn.youngsay.mybatis.mapper.UserMapper;
import cn.youngsay.mybatis.pojo.User;
import cn.youngsay.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {
    @Test
    public void testSelectUser(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.util();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"zzz","");
        List<User> list = mapper.selectUser(user);
        System.out.println(list);
    }
}
