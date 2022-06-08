import java.util.Arrays;

class Student implements Comparable<Student> {

    public String name;
    public int age;

    public Student(String name, int age) {
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
    //重写compareTo方法
    @Override
    public int compareTo(Student o) {

//        if(this.age>o.age){
//            return 1;
//        }else if(this.age<o.age){
//            return -1;
//        }else {
//            return 0;
//        }
        return this.age-o.age;
    }
}
public class Compare {

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("panghu",20),
                new Student("xiaofu",18),
                new Student("daxiong",19),
                new Student("jingxiang",16)
        };

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
