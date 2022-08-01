package operat;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddBook implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入书名：");
        String name = scanner.next();
        System.out.println("输入作者名：");
        String author = scanner.next();
        System.out.println("输入书类型：");
        String category = scanner.next();
        System.out.println("输入书价格：");
        int price = scanner.nextInt();

        int pos = bookList.getUsedSize();
        bookList.setBooks(pos,new Book(name,author,category,price));
        bookList.setUsedSize(pos+1);
        System.out.println("图书新增成功");
    }
}
