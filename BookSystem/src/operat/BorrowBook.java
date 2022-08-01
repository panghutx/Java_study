package operat;

import book.BookList;

import java.util.Scanner;

public class BorrowBook implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        System.out.println("请输入要借阅的图书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for(int i=0;i<bookList.getUsedSize();i++){
            if(!bookList.getBooks(i).isStatus()){
                bookList.getBooks(i).setStatus(true);
                System.out.println("借阅成功");
                return;
            }
        }
        System.out.println("没有找到这本书");
    }

}
