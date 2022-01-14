package com.bit.demo;
class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println(name+"我爱美食");
    }
}
class dog extends Animal{
    public dog(String name) {
        super(name);
    }
    public void eat(){
        System.out.println("我最爱美食");
    }

}
public class Test {
    public static void main(String[] args) {
        Animal animal = new dog("包子");
        animal.eat();

    }
}
