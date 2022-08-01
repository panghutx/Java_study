package user;

import operat.*;

import java.util.Scanner;

public class AdminUser extends User{

    public AdminUser(String username) {
        super(username);
        this.operations = new Operation[]{
                new ExitSystem(),
                new AddBook(),
                new DelBook(),
                new FindBook(),
                new ShowBook()
        };
    }

    @Override
    public int menu() {
        System.out.println("你好"+getUsername()+"管理员，欢迎访问图书管理系统");
        System.out.println("1.新增图书");
        System.out.println("2.删除图书");
        System.out.println("3.查找图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
