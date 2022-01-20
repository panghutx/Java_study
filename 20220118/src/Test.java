import java.util.Arrays;
class MyArrayList{
    public int[] elem;
    public int usedSize;

    public MyArrayList(){
        this.elem=new int[10];
    }
//    public int size(){
//        return this.usedSize;
//    }

    public void display(){
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }
    public void add(int pos,int data){
        //判断pos位是否合法
        if(pos<0||pos>usedSize){
            System.out.println("不合法");
            return;
        }
        if(full()){
            this.elem=Arrays.copyOf(this.elem,2*this.elem.length);
        }

        for (int i = this.usedSize-1;i>=pos;i--) {
            this.elem[i+1]=this.elem[i];
        }
        this.elem[pos]=data;
        this.usedSize++;
    }
    //数组扩容
    public boolean full(){
        return this.usedSize == this.elem.length;
    }
}
public class Test {
    public static void main(String[] args) {
        //顺序表
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.display();

    }



    //冒泡排序
    static void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) { //躺数 [important]!!!
            for (int j = 0; j < arr.length-i-1; j++) {  //每躺次数
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
    public static void main1(String[] args) {
        int[] arr={6,5,4,3,2,1};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
