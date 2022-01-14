class Person3{

    private String name;//实例成员变量
    private int age;
    private String sex;
    private static int count = 0;//静态成员变量 由类共享数据 方法区

    public Person3(){
        System.out.println("I am Person init()!");
    }

    //实例代码块
    {
        this.name = "bit";
        this.age = 12;
        this.sex = "man";
        System.out.println("I am instance init()!");
    }

    //静态代码块
    static {
        count = 10;//只能访问静态数据成员
        System.out.println("I am static init()!");
    }

    public void show(){
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }

}
public class TestDemo1 {
    public static void main(String[] args) {
        Person3 p1 = new Person3();
        Person3 p2 = new Person3();//静态代码块是否还会被执行？
    }
}
class Person1{
    public static int count;
    public int a;
    public static void study(){

    }
}
//public class TestDemo2 {
//    public static void main(String[] args) {
//        Person1 person =new Person1();
//        Person1.count++;
//        person.a++;
//        System.out.println(Person1.count);
//        System.out.println(person.a);
//        System.out.println("===========");
//        Person1 person1 =new Person1();
//        Person1.count++;
//        person1.a++;
//        System.out.println(Person1.count);
//        System.out.println(person.a);
//    }
//}
