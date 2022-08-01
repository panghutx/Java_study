import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    public int[] elem;
    public int usedSize;
    public MyPriorityQueue(){
        this.elem =new int[10];
    }

    public void initArray(int[] array) {
        elem = Arrays.copyOf(array,array.length);
        usedSize = elem.length;
    }

    /**
     * 建堆：创建一个大根堆
     */
    public void createHeap() {
        for (int parent=(usedSize-1-1)/2; parent>=0 ; parent--) {
            shiftDown(parent,usedSize);
        }
    }

    /**
     * 插入一个元素
     * @param key
     */
    public void insertHeap(int key){
        //判满，扩容
        if(usedSize==elem.length){
            elem = Arrays.copyOf(elem,elem.length*2);
        }
        elem[usedSize++]=key;
        shiftUp(usedSize-1);

    }

    /**
     * 删除一个元素
     * 只能删除队列顶端元素
     */
    public int deleteHeap(){
        //判空
        if(usedSize==0){
            return -1;
        }
        int old = elem[0];
        swap(elem,0,usedSize-1);
        usedSize--;
        shiftDown(0,usedSize);
        return old;
    }

    private void shiftUp(int child) {
        int parent = (child-1)/2;
        while(child>0){
            if(elem[parent]<elem[child]){
                swap(elem,parent,child);
                child=parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    private void shiftDown(int parent, int len) {
        int child = parent*2+1;
        while(child<len){
            //右节点要小于usedSize以防越界
            //child保存最大值的下标
            if(child+1<len && elem[child]<elem[child+1]){
                child++;
            }
            //如果子树大于根节点，向下调整，否则退出循环
            if(elem[child]>elem[parent]){
                //交换
                swap(elem,parent,child);
                //更改父节点和子节点的位置
                parent = child;
                child=parent*2+1;
            }else {
                break;
            }
        }

    }
    private void swap(int[] elem,int i,int j ){
        int tmp = elem[i];
        elem[i]=elem[j];
        elem[j]=tmp;
    }

    public static void main1(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        MyPriorityQueue priorityQueue =new MyPriorityQueue();
        priorityQueue.initArray(arr);
        priorityQueue.createHeap();
        //priorityQueue.insertHeap(80);
        priorityQueue.deleteHeap();
    }

    public static void main2(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(34);
        priorityQueue.offer(56);
        priorityQueue.offer(12);
        priorityQueue.offer(8);
        System.out.println(priorityQueue);
    }

    public static void main3(String[] args) {
        int[] arr= {1,3,5,7,2,4,6,8};
        int[] ret=new int[4];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = 0; i < 4; i++) {
            ret[i] = priorityQueue.poll();
        }
        System.out.println(Arrays.toString(ret));
    }

    /**
     * top-k问题
     * @param arr
     * @param k
     * @return
     */

    public int[] smallestK(int[] arr, int k) {


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            int top = priorityQueue.peek();
            if(arr[i]<top){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i <k ; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }

    /**
     * 堆排序问题:从小到大排序
     */
    public void heapSort(){
        int end = usedSize-1;
        while(end>0){
            swap(elem,0,end);
            shiftDown(0,end);
            end--;
        }
    }
    public static void main5(String[] args) {
        MyPriorityQueue myPriorityQueue =new MyPriorityQueue();
        int[] arr = {1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(myPriorityQueue.smallestK(arr,4)));
    }

    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue =new MyPriorityQueue();
        int[] arr = {1,3,5,7,2,4,6,8};
        myPriorityQueue.initArray(arr);
        myPriorityQueue.createHeap();
        myPriorityQueue.heapSort();

    }
}
