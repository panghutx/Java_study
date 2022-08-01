package operat;

import book.BookList;

import java.util.Scanner;

public class ReturnBook implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");

        System.out.println("请输入要归还的图书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for(int i=0;i<bookList.getUsedSize();i++){
            if(bookList.getBooks(i).isStatus()){
                bookList.getBooks(i).setStatus(false);
                System.out.println("归还成功");
                return;
            }
        }
        System.out.println("没有找到这本书");
    }
}
