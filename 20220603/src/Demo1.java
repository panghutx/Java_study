class Phone implements Cloneable{
    public String phone;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public int age;
    Phone p = new Phone();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person tmp = (Person) super.clone();
        tmp.p= (Phone) this.p.clone();
        return tmp;
    }


    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", p.phone=" + p.phone +
                '}';
    }
}
public class Demo1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.age=20;

        person.p.phone="xiaomi";
        Person person2 = (Person)person.clone();
        person2.age=10;

        person2.p.phone="iphone";
        System.out.println(person);
        System.out.println(person2);
    }

}
