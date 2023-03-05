import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.SqlSessionUtil;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestDemo {
    @Test
    public void addTest() throws IOException {
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqulSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"panghutx123","123zzz");
        int ret = userMapper.addUser(user);
        System.out.println(ret);
    }

    @Test
    public void selectTest() throws IOException {
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqulSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(9);
        System.out.println(user);
    }

    @Test
    public void selectAllTest() throws IOException {
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqulSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.selectAll();
        Iterator<User> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void selectByConditionTest() throws IOException {
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqulSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<Integer,Object> map = userMapper.selectByCondition();
        System.out.println(map);
    }

    @Test
    public void selectVagueTest() throws IOException {
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqulSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.selectVague("zzz");
        System.out.println(list);
    }

    @Test
    public void DeleteTest() throws IOException {
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqulSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteByCondition("4,10,13");
    }
}
