package User;

import java.util.Scanner;

public class normalUser extends user{
    public normalUser(String name) {
        super(name);
    }

    public void menu(){
        System.out.println("你好"+this.getName()+"用户,欢迎访问图书管理系统");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("请输入你的选择");
        int choice;
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();

    }
}
