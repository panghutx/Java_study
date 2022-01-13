package com.bit.demo;
abstract class Shape{
    abstract public void draw();
    void func(){
        System.out.println("hhhh");
    }
}
class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("123");
    }


}
public class TestDemo {
    public static void main(String[] args) {
        Shape shape = new Rect();
        shape.draw();
    }
}
