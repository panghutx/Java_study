class Person{
    //成员变量、字段、属性
    private int age;
    private String name;
    //成员方法

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

    public void sayhi(){
        System.out.println(name+"你好呀，你已经"+age+"岁了！");
    }
}
public class TestDemo2 {

    public static void main(String[] args) {
        //类的实例化
        Person per= new Person();

        per.sayhi();


    }
}
