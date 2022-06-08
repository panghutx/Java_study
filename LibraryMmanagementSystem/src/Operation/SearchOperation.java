package Operation;

import Book.BookList;

import java.util.Scanner;

public class SearchOperation implements IoOperation{

    @Override
    public int work(BookList bookList) {
        System.out.println("查找图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        int pos = bookList.getUsedSize();
        for(int i=0;i<pos;i++){
            if(bookList.getBook(i).getName().equals(name)){
                System.out.println("找到了！！");
                System.out.println(bookList.getBook(i));
                break;
            }
        }
        //说明没找到
        System.out.println("没找到"+name);

        return pos;
    }
}
