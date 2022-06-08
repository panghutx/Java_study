package Book;

public class BookList {

    private int usedSize;

    Book[] book = new Book[10];



    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public void init(){
        book[0] = new Book("活着","小说","余华",34.7);
        book[1] = new Book("一句顶一万句","小说","刘震云",26.8);
        book[2] = new Book("一分钟精通C++","成功学","panghutx",354.3);

    }

    public Book getBook(int pos){
        return this.book[pos];
    }
    public void setBook(int pos, Book book){
        this.book[pos]=book;
        this.usedSize++;
    }
}
