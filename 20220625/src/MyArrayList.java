import java.util.Arrays;

public class MyArrayList {
    public int[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = new int[10];

    }
    //判断pos位置是否合法
    public boolean posIsLegal(int pos){
        if(pos<0||pos>this.usedSize){
            System.out.println("pos位置不合法");
            return false;
        }
        return true;
    }
    //判断数组是否满了，满了就扩容
    public void isFull(){
        if(elem.length==this.usedSize){
            elem = Arrays.copyOf(elem,elem.length*2);
            System.out.println("扩容成功");
        }
    }
    // 打印元素
    public void display() {
        for (int i=0;i<this.usedSize;i++){
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }
    // 新增元素,默认在数组最后新增
    public void add(int data) {
        //判断数组是否满了,满了就扩容
        isFull();
        elem[this.usedSize]=data;
        this.usedSize++;
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //判断数组是否满了
        isFull();
        if(posIsLegal(pos)){
            //合法
            for(int i=this.usedSize-1;i>=pos;i--){
                elem[i+1]=elem[i];
            }
            //pos及其之后的元素已经后移一位了
            elem[pos]=data;
            this.usedSize++;
        }
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i=0;i<this.usedSize;i++){
            if(elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int get(int pos) {

        try {
            //判断是否合法
            if(pos<0||pos>=this.usedSize){
                throw new ArrayIndexOutOfBoundsException();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        return elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void set(int pos, int value) {
        //判断是否合法
        if(pos<0||pos>=this.usedSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        elem[pos]=value;

    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int i=0;
        for (i = 0; i < this.usedSize; i++) {
            if(elem[i]==toRemove){
                //找到关键字的下标位置
                break;
            }
        }
        for (; i <this.usedSize-1 ; i++) {
            elem[i]=elem[i+1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
}
