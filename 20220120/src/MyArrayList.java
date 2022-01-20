import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList {
    public int[] elem;
    public int usedSize;
    public MyArrayList()
    {
        this.elem=new int[10];
    }
    //打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //获取顺序表长度
    public int size(){
        return this.usedSize;
    }
    //在pos位置新增元素
    public void add(int pos,int data){
        //判断pos位是否合法
        if(pos<0||pos>this.usedSize){
            return;
        }
        //判断是否满了
        if(isfull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //填充
        for (int i = this.usedSize-1; i >=pos; i--) {
            this.elem[i+1]=this.elem[i];
        }
        this.elem[pos]=data;
        this.usedSize++;
    }
    public boolean isfull(){
        return this.usedSize==this.elem.length;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind) {
        //二分查找
//        Arrays.sort(this.elem);
//        int left=0;
//        int right=this.usedSize-1;
//        while(left<=right){
//            int mid=(left+right)>>>1;
//            if(this.elem[mid]<toFind){
//                left=mid+1;
//            }else if(this.elem[mid]>toFind){
//                right=mid-1;
//            }else{
//                return true;
//            }
//        }
//        return false;
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i]==toFind)
                return true;
        }
        return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i]==toFind)
                return i;
        }
        return -1;
    }
    //获取pos位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>=this.usedSize){
            return -1; //暂时这样写，后期可以抛异常
        }
        return this.elem[pos];

    }
    //给pos下标元素设为value
    public void setPos(int pos, int value) {
        if(pos<0||pos>=this.usedSize)
            return;
        this.elem[pos]=value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index=search(toRemove);
        if(index==-1){
            return;
        }else{
            for (int i = index; i <this.usedSize-1 ; i++) {
                this.elem[i]=this.elem[i+1];
            }
            this.usedSize--;
        }
    }
    //清空顺序表
    public void clear() {
        this.usedSize=0;
        //如果是引用类型
//        for (int i = 0; i < this.usedSize; i++) {
//            this.elem[i]=null;
//        }
    }
}
