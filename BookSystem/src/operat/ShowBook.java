package operat;

import book.BookList;

import java.util.Arrays;

public class ShowBook implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");

        for(int i=0;i< bookList.getUsedSize();i++){
            System.out.println(bookList.getBooks(i));
        }
    }
}
