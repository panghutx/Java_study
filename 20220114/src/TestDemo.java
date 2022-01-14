class Person {
    //字段、成员变量、属性
    public int age;
    public String name;
    public String sex;
    //方法
    //带有一个参数的构造方法
    public Person(){
        System.out.println("I am the constructor method of one Parameter  ");
    }
    //带有3个参数的构造方法
    public Person(String name,int age,String sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void study() {
        System.out.println(this.name+"正在学习");
    }

}
public class TestDemo {
    public static void main(String[] args) {
        //类的实例化
        Person person1=new Person();
        Person person2=new Person("panghutx",12,"male");
        person2.study();
        System.out.println(person2.toString());

    }
}
