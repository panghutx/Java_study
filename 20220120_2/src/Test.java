public class Test {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.creatList();
        myLinkedList.display();
        System.out.println(myLinkedList.contains(1));
        System.out.println(myLinkedList.size());
        myLinkedList.addFirst(66);
        myLinkedList.display();
        myLinkedList.addLast(99);
        myLinkedList.display();
        myLinkedList.addIndex(3,44);
        myLinkedList.display();
        myLinkedList.removeAllKey(22);
        myLinkedList.display();
    }
}
