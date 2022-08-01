import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        //向下转型 设置url和账号密码
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/panghutx?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("zzzzzz");
        //与数据库建立连接
        Connection connection = dataSource.getConnection();
        //构造语句对象
        String sql = "insert into tps values(?,?)";
        //输入要插入的内容
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入id:");
        int id =scanner.nextInt();
        System.out.println("请输入name:");
        String name = scanner.next();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,id);
        statement.setString(2,name);
        System.out.println(statement);

        int ret = statement.executeUpdate();
        System.out.println(ret);
        //关闭资源
        connection.close();
        statement.close();
    }
}
