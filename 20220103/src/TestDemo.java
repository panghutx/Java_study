import java.util.Arrays;

class MyArrayList {

    public int[] elem;
    public int usedSize;//有效的数据个数

    public MyArrayList() {
        this.elem = new int[10];
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // 获取顺序表的有效数据长度
    public int size() {
        return this.usedSize;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(pos < 0 || pos > usedSize) {
            System.out.println("pos 位置不合法！");
            return;
        }
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //3、
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置,找不到返回-1
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {

        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("pos 位置不合法");
            return -1;//所以 这里说明一下，业务上的处理，这里不考虑  后期可以抛异常
        }
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return -1;
        }
        return this.elem[pos];
    }

    public boolean isEmpty() {
        return this.usedSize==0;
    }

    // 给 pos 位置的元素设为/更新 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        this.elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
//        int index=0;
//        for (int i = 0; i < this.usedSize; i++) {
//            if(this.elem[i]==toRemove){
//                index=i;
//            }
//        }
//        for (int i = index; i < this.usedSize-1; i++) {
//            this.elem[i]=this.elem[i+1];
//        }
//        this.usedSize--;

        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        int index = search(toRemove);
        if(index == -1) {
            System.out.println("没有你要删除的数字！");
            return;
        }
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
        //this.elem[usedSize] = null; 如果数组当中是引用数据类型。
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
        /*for (int i = 0; i < usedSize; i++) {
            this.elem[i] = null;
        }
        this.usedSize = 0;
        */
    }
}
public class TestDemo {
    public static void main(String[] args) {
        MyArrayList mal=new MyArrayList();
        for (int i = 0; i < 10; i++) {
            mal.add(i,i);

        }
        mal.display();

    }


}
