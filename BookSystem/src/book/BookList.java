package book;

public class BookList {
    private Book[] books;
    private int usedSize;

    public void init(){
        //初始化图书
        books = new Book[10];
        books[0]=new Book("活着","余华","小说",34);
        books[1]=new Book("在细雨中呐喊","余华","小说",38);
        books[2]=new Book("一句顶一万句","刘震云","小说",32);
        this.usedSize=3;
    }

    public Book getBooks(int pos) {
        return books[pos];
    }

    public void setBooks(int pos,Book book) {
        books[pos]=book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }





}
