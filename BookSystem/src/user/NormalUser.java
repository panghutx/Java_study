package user;

import operat.*;

import java.util.Scanner;

public class NormalUser extends User{

    public NormalUser(String username) {
        super(username);
        this.operations = new Operation[]{
                new ExitSystem(),
                new BorrowBook(),
                new ReturnBook(),
                new FindBook()
        };
    }

    @Override
    public int menu() {
        System.out.println("你好"+this.getUsername()+"用户，欢迎访问图书管理系统");
        System.out.println("1.借阅图书");
        System.out.println("2.归还图书");
        System.out.println("3.查找图书");
        System.out.println("0.退出系统");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
