public class Test {
    public static void main(String[] args) {
        byte[] arr1 = {'a','b','c'};
        char[] arr2 = {'a','b','c'};
        String strings = new String(arr1);
        System.out.println(strings);
        String string2 =new String(arr2);
        System.out.println(string2);

    }
    public static void main5(String[] args) {
        //字符串拼接
        String str="panghu";
        for (int i = 0; i < 10; i++) {
            str+=i;
        }
        //String---->StringBuffer
        StringBuffer sb1=new StringBuffer();
        System.out.println(sb1.append(str));
        //StringBuffer的方法reverse()
        System.out.println(sb1.reverse());
        System.out.println(str.toString());
        System.out.println("========================");
        StringBuffer sb = new StringBuffer("panghu");
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        //StringBuffer--->String
        String ss= sb.toString();
        System.out.println(ss);
    }
    public static void main4(String[] args) {
        //trim
        String str="   Pang   hu    ";
        System.out.println(str.trim());
        //length()
        System.out.println(str.length());
    }
    public static void main3(String[] args) {
        //字符串的拆分
        String str1="name:panghu,age:21,sex:male";
        String[] strings = str1.split(",");
        for (String s:strings) {
            //System.out.println(s);
            String[] strings1 = s.split(":");
            for (String ss:strings1) {
                System.out.println(ss);
            }
        }
        //特殊字符串的拆分
        String string = "128.166.1.1";
        String[] strings1 =string.split("\\.");
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }
    }
    public static void main2(String[] args) {
        //字符串的替换
        String str1="Hello,Java";
        //替换首个位置
        System.out.println(str1.replaceFirst("l", "g"));
        //替换所有位置
        System.out.println(str1.replace("l", "a"));
    }
    public static void main1(String[] args) {
        //字符串的查找
        String str1="abecabcdabcef";
        String str2="abc";
        //判断一个字串是否存在
        boolean ret =str1.contains(str2);
        System.out.println(ret);
        //从头查找指定字符串，返回索引
        int index= str1.indexOf(str2);
        System.out.println(index);
        //从指定位置由前往后查找字符串
        int index1 = str1.indexOf(str2,4);
        System.out.println(index1);
        //从后查找字符串
        int index2 =str1.lastIndexOf(str2);
        System.out.println(index2);
        //从指定位置有后往前查找字符串
        System.out.println(str1.lastIndexOf(str2, 11));

    }

}
