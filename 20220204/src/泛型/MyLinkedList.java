package 泛型;
//MyLinkedList<T>

public class MyLinkedList {
    public Object[] elem;
    public int usedSize;
    public MyLinkedList(){
        this.elem=new Object[10];

    }
    public void add(Object val){
         this.elem[this.usedSize++]=val;
    }
    public Object getPos(int index){
        return this.elem[index];

    }
    public void display(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}

