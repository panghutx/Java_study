import java.util.Arrays;

public class Sort {
    /**
     * 直接插入排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param arr
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j=i-1;
            int tmp=arr[i];
            for (;j>=0;j--){
                if(arr[j]>tmp){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]=tmp;
        }
    }

    public static void shellSort(int[] arr,int gap){
        for (int i = gap; i < arr.length; i++) {
            int j=i-gap;
            int tmp=arr[i];
            for (;j>=0;j-=gap){
                if(arr[j]>tmp){
                    arr[j+gap]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+gap]=tmp;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度：O(N^1.3-N^1.5)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void shell(int[] arr){
        //1.分组
        int gap= arr.length;
        while(gap>1){
            //2.排序
            shellSort(arr,gap);
            gap/=2;
        }
        shellSort(arr,1);
    }

    /**
     * 简单选择排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min=i;
            for (int j = i+1; j < arr.length; j++) {
                //选出最小的元素，与i的位置交换
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,i,min);
        }
    }

    /**
     * 堆排序
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void heapSort(int[] arr){
        //升序，建大堆
        createHeap(arr);
        //堆排序
        int end=arr.length-1;
        while(end>0){
            swap(arr,0,end);
            shiftDown(arr,0,end);
            end--;
        }
    }

    private static void createHeap(int[] arr) {

        for (int parent = (arr.length-1-1)/2; parent>=0; parent--) {
            shiftDown(arr,parent,arr.length);
        }
    }

    private static void shiftDown(int[] arr, int parent, int length) {
        int child=parent*2+1;
        while(child<length){
            if(child+1<length && arr[child+1]>arr[child]){
                child++;
            }
            if(arr[child]>arr[parent]){
                swap(arr,parent,child);
                parent=child;
                child=child*2+1;
            }else{
                break;
            }
        }

    }

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flg=true;
            for (int j=0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j+1,j);
                    flg=false;
                }
            }
            //说明已经排序好了，不必再继续了
            if(flg){
                break;
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(logN)
     * 稳定性：不稳定
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int basis = findBasis(arr,left,right);
        quickSort(arr,left,basis-1);
        quickSort(arr,basis+1,right);
    }
    public static void quickSort2(int[] arr,int left,int right) {

    }

    private static int findBasis(int[] arr, int left, int right) {
        int tmp=arr[left];
        while(left<right){
            while(left<right && arr[right]>=tmp){
                right--;
            }
            //右侧找到小于tmp的值
            arr[left]=arr[right];
            while(left<right && arr[left]<=tmp){
                left++;
            }
            //左侧找到大于tmp的值
            arr[right]=arr[left];
        }
        //left与right相遇
        arr[left]=tmp;
        return left;
    }

    private static void swap(int[] arr, int i, int min) {
        int tmp=arr[i];
        arr[i]=arr[min];
        arr[min]=tmp;
    }

    /**
     * 归并排序
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(N)
     * 稳定性：稳定
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        //先分解
        int mid=(left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        //再归并
        merge(arr,left,right,mid);
    }

    private static void merge(int[] arr, int left,int right, int mid) {
        int s1=left;
        int s2=mid+1;
        int[] ret = new int[right-left+1];
        int i=0;
        while(s1<=mid && s2<=right){
            if(arr[s1]>arr[s2]){
                ret[i++]=arr[s2++];
            }else{
                ret[i++]=arr[s1++];
            }
        }
        //有一个数组遍历完了
        while(s1<=mid){
            ret[i++]=arr[s1++];
        }
        while(s2<=right){
            ret[i++]=arr[s2++];
        }
        //拷贝数组
        for (int j = 0; j < ret.length; j++) {
            arr[j+left]=ret[j];
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{9,5,1,4,8,6};
        //insertSort(arr);
        //shell(arr);
        //selectSort(arr);
        //heapSort(arr);
        //bubbleSort(arr);
        //quickSort(arr,0,arr.length-1);
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
