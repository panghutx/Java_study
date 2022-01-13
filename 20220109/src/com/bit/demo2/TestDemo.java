package com.bit.demo2;
interface IShape{
    void func();
}
class Race implements IShape{
    @Override
    public void func() {
        System.out.println("123");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        IShape is =new Race();
        is.func();
    }
}
