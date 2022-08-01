import cn.youngsay.mybatis.mapper.SelectMapper;
import cn.youngsay.mybatis.pojo.User;
import cn.youngsay.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectTest {
    @Test
    public void testSelectAll(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.util();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = new HashMap<>();
        map = selectMapper.selectAll();
        System.out.println(map);
    }

    @Test
    public void testSelectVague(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.util();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = new ArrayList<>();
        list = selectMapper.selectVague("z");
        System.out.println(list);
    }

    @Test
    public void testDelete(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.util();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        selectMapper.delete("1,3");
    }

    @Test
    public void testInsert(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.util();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = new User(null,"hello1234","123abc");
        mapper.insetUser(user);
        System.out.println(user);
    }
}
