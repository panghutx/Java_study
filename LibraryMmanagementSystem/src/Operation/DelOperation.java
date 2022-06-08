package Operation;

import Book.BookList;

import java.util.Scanner;

public class DelOperation implements IoOperation {
    public DelOperation() {
    }

    @Override
    public int work(BookList bookList) {
        int flg=0;
        int i=0;
        System.out.println("删除图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的图书的名字：");
        String name = scanner.nextLine();
        int pos = bookList.getUsedSize();
        for(i=0;i<pos;i++){
            if(bookList.getBook(i).getName().equals(name)){
                System.out.println("找到了！！");
                flg=1;
                break;
            }
        }

        if(flg==1){
            //找到了
            for(;i<pos;i++){

            }
        }

        return pos;
    }
}
