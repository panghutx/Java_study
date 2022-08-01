package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 封装user操作
 * 1.添加用户
 * 2.根据id查找用户对象
 * 3.根据用户名查找用户对象
 */

public class UserDao {
    public void inset(User user){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2，构造sql语句
            String sql = "insert into user values(null,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            //3.执行语句
            int ret = statement.executeUpdate();
            if(ret==1){
                System.out.println("插入用户成功");
            }else{
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public User selectByID(int userID){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造语句
            String sql = "select * from user where userId=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userID);
            //3.执行语句
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public User selectByUsername(String username){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet =null;
        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造sql
            String sql = "select * from user where username=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            //3.执行语句
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        //插入用户
        User user = new User();

        user.setUsername("panghutx");
        user.setPassword("zzzzzz");
        userDao.inset(user);

        //System.out.println(userDao.selectByID(3));
        //System.out.println(userDao.selectByUsername("admin"));
    }
}
