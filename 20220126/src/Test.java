public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.display();
        System.out.println("=========");
        myLinkedList.remove(3);
        myLinkedList.display();
        myLinkedList.addIndex(0,66);
        myLinkedList.display();


    }
}
