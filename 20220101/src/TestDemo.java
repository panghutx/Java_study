import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int[] arr2=Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(arr2));
        arr[0]=100;
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr));
        int[] arr3=Arrays.copyOfRange(arr,1,3);
        System.out.println(Arrays.toString(arr3));


    }
    public static void main1(String[] args) {
        //一维数组的定义
//        int[] arr={1,2,3,4,5};
//        int[] arr1=new int[]{1,2,3,4,5};
//        int[] arr2=new int[5];
        //一维数组的遍历
        //method 1
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }
        //method 2
//        for (int x:arr) {
//            System.out.print(x);
//        }
        //method 3
//        System.out.println(Arrays.toString(arr));

        //二维数组的定义
//        int[][] array={{1,2,3},{4,5,6}};
//        int[][] array1=new int[][]{{7,8,9},{10,11,12}};
//        int[][] array2=new int[2][3];
        //二维数组的遍历
        //method 1
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j]+" ");
//            }
//            System.out.println();
//        }
        //method 2
//        for ( int[] x:array) {
//            for ( int y:x) {
//                System.out.print(y);
//            }
//            System.out.println();
//        }
        //method 3
//        System.out.println(Arrays.deepToString(array));
    }
}
