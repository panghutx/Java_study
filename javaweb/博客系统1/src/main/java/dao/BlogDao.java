package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 对blog表的封装操作
 * 1.新增文章
 * 2.查看列表文章
 * 3.根据文章id查找文章
 * 4.根据文章id删除文章
 */
public class BlogDao {
    public void insert(Blog blog){

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造SQL语句
            String sql = "insert into blog values(null,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,blog.getTitle());
            statement.setString(2,blog.getContent());
            statement.setTimestamp(3,blog.getPostTime());
            statement.setInt(4,blog.getUserID());
            //3.执行sql
            int ret = statement.executeUpdate();
            if(ret==1){
                System.out.println("插入文章成功");
            }else{
                System.out.println("插入文章失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }

    }

    public List<Blog> selectAll(){

        List<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造SQL
            String sql = "select * from blog order by postTime desc";
            statement = connection.prepareStatement(sql);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果
            while(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogID(resultSet.getInt("blogID"));
                blog.setTitle(resultSet.getString("title"));
                //blog.setContent(resultSet.getString("content"));
                //截取摘要长度
                String content = resultSet.getString("content");
                if(content.length()>90){
                    content=content.substring(0,90)+"……";
                }
                blog.setContent(content);
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserID(resultSet.getInt("userID"));
                blogs.add(blog);
            }
            return blogs;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public Blog selectOne(int blogID){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造SQL
            String sql = "select * from blog where blogID=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogID);
            //3.执行SQL
            resultSet = statement.executeQuery();
            //4.遍历结果
            if(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogID(resultSet.getInt("blogID"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserID(resultSet.getInt("userID"));
                return blog;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public void delete(int blogID){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.建立连接
            connection = DBUtil.getConnection();
            //2.构造sql
            String sql = "delete from blog where blogID=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogID);
            //3.执行sql
            int ret = statement.executeUpdate();
            if(ret==1){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public static void main(String[] args) {

        //插入文章测试
//        BlogDao blogDao = new BlogDao();
//        Blog blog = new Blog();
//        blog.setTitle("hello");
//        blog.setContent("呵呵哈哈哈或或");
//        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
//        blog.setUserID(3);
//        blogDao.insert(blog);

        //查找文章测试
        //System.out.println(blogDao.selectAll().toString());

        //根据id查找文章测试
        //System.out.println(blogDao.selectOne(1).toString());

        //删除文章测试
        //blogDao.delete(1);


    }
}
