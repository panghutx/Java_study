package operat;

import book.BookList;

import java.util.Scanner;

public class FindBook implements Operation{


    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        System.out.println("请输入要查找的图书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for(int i=0;i<bookList.getUsedSize();i++){
            if(bookList.getBooks(i).getName().equals(name)){
                System.out.println(bookList.getBooks(i).toString());
                return;
            }
        }
        System.out.println("没有找到这本书");
    }
}
