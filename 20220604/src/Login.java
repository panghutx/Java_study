import java.util.Scanner;
class UserException extends Exception{
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }
}

class PasswordException extends Exception{
    public PasswordException() {
        super();
    }

    public PasswordException(String message) {
        super(message);
    }
}
public class Login {

    public static void main(String[] args) throws UserException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String uname = scanner.next();
        System.out.println("请输入密码");
        String pword = scanner.next();
        try {
            if(!uname.equals("panghutx")){
                throw new UserException("用户名错误");
            }
            if(!pword.equals("123456")){
                throw new PasswordException("密码错误");
            }
            System.out.println("登陆成功");
        }catch (PasswordException | UserException e) {
            e.printStackTrace();
        }

    }
}
