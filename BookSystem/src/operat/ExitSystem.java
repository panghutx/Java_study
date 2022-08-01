package operat;

import book.BookList;

public class ExitSystem implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
    }
}
