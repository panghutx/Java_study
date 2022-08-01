public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(3,10);
        myArrayList.display();
        System.out.println(myArrayList.contains(10));
        System.out.println(myArrayList.get(5));
        myArrayList.set(2,5);
        myArrayList.display();
        myArrayList.remove(10);
        myArrayList.display();

    }
}
