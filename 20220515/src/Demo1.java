class Animal{
    public String name = "animal";
    public int age;



    public void eat(){
        System.out.println(age+"岁的"+name+"正在吃东西！");
    }
}

class Dog extends Animal{
    String name ="dog";

    public void bite(){
        System.out.println(super.name+"咬你");

    }
}


public class Demo1 {
    /**
     * 继承 inherited
     */

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
        Dog dog = new Dog();
        dog.eat();
        dog.bite();
        System.out.println("===========");
        System.out.println(dog.name);
        dog.bite();


    }

}
