package 泛型;

import java.util.ArrayList;

public class Test {
    //初识泛型
    public static void main(String[] args) {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("panghu");
        arrayList.add("daxiong");
        System.out.println(arrayList.toString());

        ArrayList<Integer> arrayList1=new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
    }

    //自定义顺序表
    public static void main1(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add("PANGHU");
        myLinkedList.add(3);
        myLinkedList.display();
        System.out.println(myLinkedList.getPos(2));
    }
}
