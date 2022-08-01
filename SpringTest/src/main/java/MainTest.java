import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.sayHi("java"));
        User user1 = new User();
        System.out.println(user1.sayHi("1111"));
    }
}
