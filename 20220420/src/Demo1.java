/**
 * Created with IntelliJ IDEA.
 * Description: 类型转换
 * 能表示的范围小的数可以隐式转换成表示范围更大的数；表示范围更大的数不能转换成表示范围小的数，只能强制类型转换，但会造成精度丢失。
 * 字符串型转换成整型，Integer.parseInt(str)
 * 整型转换成字符串，可以直接拼接，如123转换成字符串  123+""  也可以用String.valueOf(123)
 * User: panghu
 * Date: 2022-04-20
 * Time: 11:42
 */
public class Demo1 {

    public static void main1(String[] args) {
        String str = "1234";
        int a = Integer.parseInt(str);
        System.out.println(a);
        String stt1 = String.valueOf(123);
    }

    public static void main(String[] args) {
        //强制类型转换
        int a=10;
        long b=100L;
        a=(int)b;
        System.out.println(a);
    }
}
