/**
 * 抽象类和接口的使用
 */
interface Running{
    void run(); //方法不加修饰符，默认为public abstract void run()
}
interface Flying{
    void fly();
}
abstract class Animal {
    public String name;
    //抽象类中也可以有构造方法
    public Animal(String name) {
        this.name = name;
    }

    //抽象方法，不做具体实现
    public abstract void eat();
}
class Dog extends Animal implements Running {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.name+"正在吃狗粮");
    }
    //重写接口中的run方法，必须为public，因为接口中的run方法是public，重写时要分配更高的访问权限

    @Override
    public void run() {
        System.out.println(this.name+"正在扑向他的主人");
    }
}

class Bird extends Animal implements Flying{
    //继承父类，需要重写父类的构造方法
    public Bird(String name) {
        super(name);
    }
    //重写父类的抽象方法
    @Override
    public void eat() {
        System.out.println(this.name+"正在觅食");
    }

    //实现接口，重写接口的抽象方法
    @Override
    public void fly() {
        System.out.println(this.name+"正在天空中自由地翱翔");
    }
}
public class Demo1 {

    public static void main(String[] args) {

        Dog dog = new Dog("旺旺");
        dog.eat();
        dog.run();
        Bird bird  = new Bird("飞儿");
        bird.eat();
        bird.fly();

    }

}
