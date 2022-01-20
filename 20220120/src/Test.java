public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i,i);
        }
        myArrayList.display();
        boolean flg = myArrayList.contains(6);
        System.out.println(flg);
        System.out.println(myArrayList.getPos(2));
        myArrayList.setPos(9,88);
        myArrayList.display();
        myArrayList.remove(88);
        myArrayList.display();
    }

}
