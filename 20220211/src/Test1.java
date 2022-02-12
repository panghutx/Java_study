import java.util.*;

class Student implements Comparable<Student>{
    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
    public int compareTo(Student o){
        return this.age-o.age;
    }
}
public class Test1 {
    public static void main(String[] args) {
    //new AraayList()在new之后没有分配容量，添加元素之后分配10个容量
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<>(30);
        ArrayList<Integer> list3 = new ArrayList<>(list1);

    }

    public static void main2(String[] args) {
        //复杂数据类型的排序
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("panghu",20));
        students.add(new Student("wangwenkai",10));
        students.add(new Student("cuixinbang",23));
        Collections.sort(students);
        System.out.println(students);

    }
    public static void main1(String[] args) {
        //简单数据类型的排序
        ArrayList<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(4);
        collection.add(3);
        Collections.sort(collection);
        System.out.println(collection);
    }


}

