class Person{
    private int age;
    private String name;
    public void sayHi(){
        System.out.println("你好呀，"+name+",你已经"+age+"岁了！");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class TestDemo2 {
    //public和private的使用
    public static void main(String[] args) {
        Person per = new Person();
//        per.age=12;
//        per.name;
        per.setAge(12);
        per.setName("张忠智");
        per.sayHi();
    }
}
