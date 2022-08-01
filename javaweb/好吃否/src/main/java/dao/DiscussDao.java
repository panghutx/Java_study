package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscussDao {

    public void insert(Discuss discuss){
        Connection connection =null;
        PreparedStatement statement = null;

        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造语句
            String sql = "insert into discuss values(null,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,discuss.getScore());
            statement.setString(2,discuss.getTitle());
            statement.setString(3,discuss.getContent());
            statement.setTimestamp(4,discuss.getPostTime());
            //3.执行语句
            int ret = statement.executeUpdate();
            if(ret==1){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public List<Discuss> selectAll(){
        List<Discuss> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造
            String sql = "select * from discuss order by postTime desc";
            statement = connection.prepareStatement(sql);
            //3.执行
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Discuss discuss = new Discuss();
                discuss.setScore(resultSet.getInt("score"));
                discuss.setTitle(resultSet.getString("title"));
                discuss.setContent(resultSet.getString("content"));
                discuss.setPostTime(resultSet.getTimestamp("postTime"));
                list.add(discuss);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public List<Discuss> selectOne(String position){
        List<Discuss> list = new ArrayList<>();
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //建立连接
            connection = DBUtil.getConnection();
            //构造语句
            String sql = "select * from discuss where title like ?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,"%"+position+"%");
            //执行语句
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Discuss discuss = new Discuss();
                discuss.setScore(resultSet.getInt("score"));
                discuss.setTitle(resultSet.getString("title"));
                discuss.setContent(resultSet.getString("content"));
                discuss.setPostTime(resultSet.getTimestamp("postTime"));
                list.add(discuss);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public List<Discuss> selectOne(int score){
        List<Discuss> list = new ArrayList<>();
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //建立连接
            connection = DBUtil.getConnection();
            //构造语句
            String sql = "select * from discuss where score=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,score);
            //执行语句
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Discuss discuss = new Discuss();
                discuss.setScore(resultSet.getInt("score"));
                discuss.setTitle(resultSet.getString("title"));
                discuss.setContent(resultSet.getString("content"));
                discuss.setPostTime(resultSet.getTimestamp("postTime"));
                list.add(discuss);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public static void main(String[] args) {
        DiscussDao discussDao = new DiscussDao();
        System.out.println(discussDao.selectOne("菊"));
    }

}
