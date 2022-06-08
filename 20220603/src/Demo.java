//class Phone{
//    public String phone;
//
//}
//class Person implements Cloneable{
//    public int age;
//    public String name;
//    Phone p = new Phone();
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                ", p.phone=" + p.phone +
//                '}';
//    }
//}
//public class Demo {
//    public static void main(String[] args) throws CloneNotSupportedException {
//        Person person = new Person();
//        person.age=20;
//        person.name="zzz";
//        person.p.phone="xiaomi";
//        Person person2 = (Person)person.clone();
//        person2.age=10;
//        System.out.println("person2:"+person2.name.hashCode()+" person:"+person.name.hashCode());
//        person2.p.phone="iphone";
//        System.out.println(person);
//        System.out.println(person2);
//    }
//
//}
