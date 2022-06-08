package Operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class AddOperation implements IoOperation{
    public AddOperation() {
    }

    @Override
    public int work(BookList bookList) {
        System.out.println("增加图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入图书的作者:");
        String author = scanner.nextLine();
        System.out.println("请输入图书的类型:");
        String type = scanner.nextLine();
        System.out.println("请输入图书的价格:");
        int price = scanner.nextInt();
        int pos = bookList.getUsedSize();
        Book book = new Book(name,type,author,price);
        bookList.setBook(pos,book);
        return price;
    }
}
