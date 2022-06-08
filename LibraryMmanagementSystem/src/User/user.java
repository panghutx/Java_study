package User;

import Operation.IoOperation;

public class user{
    private String name;
    protected IoOperation[] ioOperations;

    public user(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
