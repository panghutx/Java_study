import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {

    public static User login(){
        System.out.println("请输入姓名:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.println("请输入身份: 1.管理员 2.用户");
        int id = scanner.nextInt();
        if(id==1){
           return new AdminUser(username);
        }else {
           return new NormalUser(username);
        }
    }
    public static void main(String[] args) {
        BookList bookList = new BookList();
        bookList.init();
        User user = login();
        while(true){
            int choice = user.menu();
            user.doOperation(choice,bookList);
        }

    }
}
