import java.util.Arrays;

public class QuickSort {
    /**
     * 插入排序
     * @param arr
     */
    public static void insert(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tmp =arr[i];
            int j = i-1;
            for (; j >=0 ; j--) {
                if(arr[j]>tmp){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]=tmp;
        }
    }

    /**
     * 希尔排序
     * @param arr
     * @param gap
     */
    public  static  void shell(int[] arr,int gap){
        for (int i = 1; i < arr.length; i++) {
            int j=i-gap;
            int tmp = arr[i];
            for (; j >=0 ; j-=gap) {
                if(arr[j]>tmp){
                    arr[j+gap]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+gap]=tmp;
        }
    }
    public static void group(int[] arr){
        int gap = arr.length;
        while(gap>1){
            shell(arr,gap);
            gap/=2;
        }
        shell(arr,1);
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void chooseSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    //交换
                    int tmp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }
    public static void choose2(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,i,min);
        }
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr){
        //建堆
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
        for (int parent = (arr.length-1-1)/2;parent>=0; parent--) {
            shiftDown(arr,parent,arr.length);
        }
    }

    private static void shiftDown(int[] arr,int parent,int size) {
        int child = 2*parent+1;
        while(child< size){
            if(child+1<size && arr[child+1]>arr[child]){
                child++;
            }
            parent = (child-1)/2;
            if(arr[parent]<arr[child]){
                swap(arr,parent,child);
                parent=child;
                child=2*child+1;
            }else{
                break;
            }
        }

    }

    /**
     * 快速排序
     * @param arr
     */
    public static  void  quick(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        //找基准之前，使用三数取中法，找到中间大小的值
        int mid = findMid(arr,left,right);
        swap(arr,left,mid);
        int pivot = partition(arr,left,right);
        quick(arr, left, pivot-1);
        quick(arr,pivot+1,right);
    }

    private static int findMid(int[] arr, int left, int right) {
        int mid=left+(right-left)/2;
        if(arr[left]>arr[right]){
            if(arr[left]<arr[mid]){
                return left;
            }else if(arr[mid]<arr[right]){
                return right;
            }else{
                return mid;
            }
        }else {
            if(arr[left]>arr[mid]){
                return left;
            }else if(arr[mid]>arr[right]){
                return right;
            }else{
                return mid;
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int tmp =arr[left];
        while(left<right){
            while(left<right&&arr[right]>=tmp){
                right--;
            }
            //找到了
            arr[left]=arr[right];

            while(left<right&&arr[left]<=tmp){
                left++;
            }
            //找到了
            arr[right]=arr[left];
        }
        arr[left]=tmp;
        return left;

    }

    /**
     * 合并两个有序数组
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] merge1(int[] arr1,int[] arr2){
        int m=arr1.length;
        int n=arr2.length;
        int[] ret = new int[m+n];
        int aS=0;
        int bS=0;
        int aE=m-1;
        int bE=n-1;
        int i=0;
        while(aS<=aE && bS<=bE){

            if(arr1[aS]<arr2[bS]){
                ret[i]=arr1[aS];
                aS++;
            }else{
                ret[i]=arr2[bS];
                bS++;
            }
            i++;
        }
        //数组1遍历完了
        if(aS>aE) {
            for (; i <m+n ; i++) {
               ret[i]=arr2[bS];
               bS++;
            }
        }else{
            for (; i <m+n ; i++) {
                ret[i]=arr1[aS];
                aS++;
            }
        }

        return ret;
    }

    /**
     * 归并算法
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeInto(int[] arr,int left,int right){
        //先分解，再归并
        if(left>=right){
            return;
        }
        int mid = left+(right-left)/2;
        mergeInto(arr,left,mid);
        mergeInto(arr, mid+1, right);
        merge(arr,left,right,mid);
    }

    private static void merge(int[] arr, int left, int right,int mid) {
        int s1=left;
        int s2=mid+1;
        int[] ret = new int[right-left+1];
        int i=0;
        while(s1<=mid&&s2<=right){
            if(arr[s1]<arr[s2]){
                ret[i++]=arr[s1++];
            }else{
                ret[i++]=arr[s2++];
            }
        }
        //数组1还没遍历完
        while(s1<=mid){
            ret[i++]=arr[s1++];
        }
        //数组2还没遍历完
        while(s2<=right){
            ret[i++]=arr[s2++];
        }
        //拷贝数组
        for (int j = 0; j < ret.length; j++) {
            arr[j+left]=ret[j];
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{6,12,4,3};
        //quick(arr,0,arr.length-1);
        //group(arr);
        //chooseSort(arr);
        //choose2(arr);
        //heapSort(arr);
        mergeInto(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void main1(String[] args) {
        int[] arr1 = {2,6,7};
        int[] arr2 ={1,5,8,9};
        final int[] merge = merge1(arr1, arr2);
        System.out.println(Arrays.toString(merge));
    }
}
