import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //字符串的比较
        String str1="abcaBC";
        String str2="aBC";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.compareTo(str2));
        //字符串的查找
        System.out.println(str1.contains(str2));

    }
    public static void main3(String[] args) {
        //字节与字符串
        //字符串转字节
        //byte[] by={1,2,3};
        String str="abcd";
        byte[] by=str.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < by.length; i++) {
            System.out.print(by[i] + " ");
        }
        //字节转字符串
        byte[] bytes={65,66,67};
        String str1=new String(bytes);
        System.out.println(str1);
    }
    //给定字符串一个字符串, 判断其是否全部由数字所组成
    public static boolean isNum(String str){
        char[] arr=str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>'9'||arr[i]<'0'){
                return false;
            }
            }
        return true;
        }

    public static void main2(String[] args) {

        String str="1234a56";
        System.out.println(isNum(str));

    }
    public static void main1(String[] args) {
        //一、字符数组与字符串
        //1.将字符数组变成字符串
        char arr[] = new char[]{'h','e','l','l','o'};
        System.out.println(new String(arr));
        //2.将部分数组内容变成字符串
        System.out.println(new String(arr, 2, 3));
        //3.将字符串变成字符数组
        String str="hello,panghu";
        char[] arr1=str.toCharArray();
        for (int i = 0; i < arr1.length; i++) {   //数组的遍历
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        //4.取得指定索引位置的字符
        char arr2=str.charAt(3);
        System.out.println(arr2);


    }

}
