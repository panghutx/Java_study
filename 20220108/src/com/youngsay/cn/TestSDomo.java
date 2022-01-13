package com.youngsay.cn;

import java.util.Date;
class Animal{
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat(String food){
        System.out.println(this.name + "123正在吃" + food);
    }
}
class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }
    public void eat(String food){
        System.out.println(this.name+"dogdog"+food);
    }
}
class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }
    public void fly(){
        System.out.println(this.name+"正在飞");
    }
}
public class TestSDomo {
    public static void main(String[] args) {
        Animal animal=new Dog("包子");
        animal.eat("包子");

    }
}
