import java.util.Arrays;

class Student implements Comparable<Student>{
    public int age;
    public String name;

    public Student(int age,String name) {
        this.age = age;
        this.name=name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }

    }
}
public class TestDemo {
    public static void main(String[] args) {
        Student student1=new Student(12,"张忠智");
        Student student2=new Student(17,"王文凯");
        Student[] students={student1,student2};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

}
