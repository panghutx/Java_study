import java.util.Arrays;

public class TestDemo {
    public static void main9(String[] args) {
        //数组数字排列（偶数在前，奇数在后）
        int[] arr={1,2,3,4,5};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void transform(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            while(left<right&&arr[left]%2==0){
                left++;
            }
            //遇到奇数了
            while(left<right&&arr[right]%2!=0){
                right--;
            }
            //遇到偶数了
            if(left<right){
                int tmp=arr[left];
                arr[left]=arr[right];
                arr[right]=tmp;
            }

        }
    }
    public static void main8(String[] args) {
        //数组的逆序
        int[] arr={1,2,3,4,5};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void reverse(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int tmp= arr[left];
            arr[left]=arr[right];
            arr[right]=tmp;
            right--;
            left++;
        }
    }
    public static void main7(String[] args) {
        //数组排序（冒泡排序）
        int[] arr={11,2,31,14,5};
        bubbleSearch(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSearch(int[] arr){
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
            if(flg==false)
                break;
        }
    }
    public static void main6(String[] args) {
        //检查数组的有序性
        int[] arr={1,2,13,114,15};
        System.out.println(order(arr));
    }
    public static int order(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                return -1;
            }
            }
        return 1;
    }

    public static void main5(String[] args) {
        //二分法查找数组中指定元素(有序数组）
        //自定义方法：查找数组中的指定元素
        int[] arr={1,2,3,4,5};
        System.out.println(binarySearch(arr, 4));
    }
    public static int binarySearch(int[] arr,int key){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=(left+right)>>>1;
            if(arr[mid]<key){
                left=mid+1;
            }else if(arr[mid]>key){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;

    }

    public static void main4(String[] args) {
        //自定义方法：查找数组中的指定元素
        int[] arr={1,2,5,4,3};
        System.out.println(find(arr, 5));
    }
    public static int find(int[] arr,int key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }

    //查找数组中指定元素
    public static void main3(String[] args) {
        int[] arr={1,2,5,4,3};
        Arrays.sort(arr); //排序
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, -1)); //查找
    }
    //找出数组中的最大元素
    public static void main2(String[] args) {
        int[] arr={3,4,6,1,10,2};
        System.out.println(Max(arr));
    }
    public static int Max(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    //自定义方法数组的拷贝
    public static void main1(String[] args) {
        int[] arr={1,2,3,4,5};
        copy(arr);
    }
    public static void copy(int[] arr){
        int[] arr1=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i]=arr[i];
        }
        System.out.println(Arrays.toString(arr1));
    }

}
