import java.util.Arrays;
import java.util.Comparator;

class Student1 {

    public String name;
    public int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
class AgeComparator implements Comparator<Student1> {

    @Override
    public int compare(Student1 o1, Student1 o2) {
        return o1.age-o2.age;
    }
}

class NameComparator implements Comparator<Student1> {

    @Override
    public int compare(Student1 o1, Student1 o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class Compare1 {

    public static void main(String[] args) {
        Student1[] students = new Student1[]{
                new Student1("panghu",20),
                new Student1("xiaofu",18),
                new Student1("daxiong",19),
                new Student1("jingxiang",16)
        };
        AgeComparator ageComparator = new AgeComparator();
        NameComparator nameComparator = new NameComparator();
        //按年龄排序
        Arrays.sort(students,ageComparator);
        System.out.println("按年龄"+Arrays.toString(students));
        //按姓名排序
        Arrays.sort(students,nameComparator);
        System.out.println("按姓名"+Arrays.toString(students));
    }
}
