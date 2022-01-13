
import java.util.Arrays;

public class TextDemo {
    //检查数组的有序性
    public static void main10(String[] args) {
        int[] array={2,3,4,5};

        System.out.println(order(array));
    }
    public static boolean order(int[] arr){
        int left=0;
        int right=arr.length-1;
        boolean flg = true;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                flg = false;
            }
        }
        return flg;
    }
    //数组数字排列：给定一个整型数组, 将所有的偶数放在前半部分, 将所有的奇数放在数组后半部分
    public static void main9(String[] args) {
        int[] array={1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(odd(array)));

    }
    public static int[] odd(int[] arr){
        int left=0;
        int right=arr.length-1;
        while (left<right){
            while(left<right && arr[left]%2==0){
                left++;
            }
            //left遇到奇数
            while(left<right && arr[right]%2!=0){ //奇数
                right--;
            }
            //right遇到偶数
            if(left<right){
                int tmp=arr[left];
                arr[left]=arr[right];
                arr[right]=tmp;

            }

        }
        return arr;
    }
    //数组逆序
    public static void main8(String[] args) {
        int[] array={1,2,3,4,5};
        String rst = Arrays.toString(reverse(array));
        System.out.println(rst);
    }
    public static int[] reverse(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int tmp=arr[left];
            arr[left]=arr[right];
            arr[right]=tmp;
            left++;
            right--;
        }
        return arr;
    }
    //冒泡排序:给定一个数组, 让数组升序 (降序) 排序
    public static void main7(String[] args) {
        int[] array={3,23,1,44,32,10};
        String rst = Arrays.toString(bubbleSort(array));
        System.out.println(rst);
    }
    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flg=false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                    flg=true;
                }
            }
            if(flg==false){
                break;
            }
        }
        return arr;
    }
    //二分查找
    public static int indexSearch(int[] arr,int key) {
        int left = 0;
        int right = arr.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2; //>>>1无符号右移1位
            if (arr[middle] < key) {
                left = middle + 1;
            } else if (arr[middle] > key) {
                right = middle - 1;
            }else {
                return middle;
            }
        }
        return -1;
    }
    public static void main6(String[] args) {
        int[] array={3,6,7,8,9};
        int id = indexSearch(array,9);
        System.out.println(id);
    }
    //找数组中的最大值
    public static int Max(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    public static void main5(String[] args) {
        int[] array={1,6,3,4};
        int rst = Max(array);
        System.out.println(rst);
    }
    //创建方法拷贝一份数组
    public static int[] copyArray(int[] arr){
        int[] array1 =new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array1[i]=arr[i];
        }
        return array1;
    }
    public static void main4(String[] args) {
        int[] array={1,2,3,4};
        System.out.println(Arrays.toString(copyArray(array)));
    }
    //将数组转成字符串
    public static void myToString(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.print("]");
    }
    public static void main3(String[] args) {
        int[] array={1,2,3};
        myToString(array);
    }
    //将数组作为方法返回值
        //将数组元素扩大三倍
    public static int[] transform(int[] array){
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i]=array[i]*3;
        }
        return ret;
    }
        //打印新数组
    public static void PrintArray(int[] arr){
        String ret = Arrays.toString(arr);
        System.out.println(ret);
    }
    public static void main2(String[] args) {
        int[] arr={1,2,3};
        int[] output=transform(arr);
        PrintArray(output);
    }
    //练习遍历数组
    public static void main1(String[] args) {
        int[] array = {1,2,3,4};
        int[] array1 = new int[]{0,1,2,3};
        //遍历方法1
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        //遍历方法2
        for (int arr:array1
             ) {
            System.out.println(arr);

        }
        //遍历方法3
        String rst = Arrays.toString(array);
        System.out.println(rst);
    }
}
