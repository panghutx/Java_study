package user;

import book.BookList;
import operat.Operation;

public abstract class User {
    private String username;
    private int id;
    public Operation[] operations;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract int menu();

    public void doOperation(int choice, BookList bookList){
        this.operations[choice].work(bookList);
    }
}
