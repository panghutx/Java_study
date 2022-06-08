import User.adminUser;
import User.normalUser;

import java.util.Scanner;

public class Main {
    public static void login(){
        System.out.println("请输入你的姓名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入你的身份：1.管理员 2.用户");
        int identify = scanner.nextInt();
        if(identify==1){
            adminUser adminUser = new adminUser(name);
            adminUser.menu();

        }else{
            normalUser normalUser = new normalUser(name);
            normalUser.menu();
        }
    }
    public static void main(String[] args) {
        login();

    }
}
