package com.bit;

public class demo1 {
    public static void main(String[] args) {
        int a=10;
        int b=a+30;
        //常量在编译时就已经确定
    }
    public static void main1(String[] args) {
        //创建字符串
        String str1="hello";
        String str2=new String("hello");
        char[] arr={'h','e','l','l','o'};
        String str3=new String(arr);
        System.out.println(str1==str2); //false
        //比较字符串
        String str11="hello";
        String str22=new String("hello");
        System.out.println(str1==str11); //true
        System.out.println(str2==str22); //false

    }
}
