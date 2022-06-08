import java.util.ArrayList;
import java.util.Iterator;

class MyArrayList implements Iterable<Integer> {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public void init(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
    }
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}

public class Demo1 {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.init();
        Iterator<Integer> iterator = myArrayList.arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
