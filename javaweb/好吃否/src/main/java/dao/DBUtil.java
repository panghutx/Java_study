package dao;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/delicious?characterEncoding=utf8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "zzzzzz";

    private static DataSource dataSource = null;

    private static DataSource getDataSource(){
        if(dataSource==null){
            dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setURL(URL);
            ((MysqlDataSource)dataSource).setUser(USERNAME);
            ((MysqlDataSource)dataSource).setPassword(PASSWORD);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DiscussDao discussDao = new DiscussDao();
//        Discuss discuss = new Discuss();
//        discuss.setScore(4);
//        discuss.setTitle("梅园三楼饺子");
//        discuss.setContent("很好吃，很喜欢");
//        discuss.setPostTime(new Timestamp(System.currentTimeMillis()));
//        discussDao.insert(discuss);
        System.out.println(discussDao.selectAll());
    }

}
