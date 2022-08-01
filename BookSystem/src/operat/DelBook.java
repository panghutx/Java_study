package operat;

import book.BookList;

import java.util.Scanner;

public class DelBook implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        System.out.println("请输入要删除的图书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int pos=0;
        boolean flg= false;
        for(int i=0;i<bookList.getUsedSize();i++){
            if(bookList.getBooks(i).getName().equals(name)){
                //找到书后记录该书下标
                pos = i;
                flg = true;
                break;
            }
        }
        if(!flg){
            System.out.println("没有找到这本书");
            return;
        }

        for(int i=pos;i<bookList.getUsedSize()-1;i++){
            bookList.setBooks(i,bookList.getBooks(i+1));
        }
        bookList.setUsedSize(bookList.getUsedSize()-1);
        System.out.println("删除成功");

    }
}
