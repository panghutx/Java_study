import java.util.LinkedList;

public class Test {


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(); //创建顺序表
        //添加数据
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);
        System.out.println(linkedList.get(2));
    }
}
