import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String all = String.join(".","www","youngsay","cn");
        System.out.println(all);
        String str = "youngsay";

        char c = str.charAt(1); //返回给定位置的代码单元
        System.out.println(c); //o
        int i = str.codePointAt(1); //返回给定位置开始的码点
        System.out.println(i);  //111
        int i1 = str.offsetByCodePoints(0,5); //返回码点的索引
        System.out.println(i1); //5
        System.out.println(str.compareTo("wangyouwu")); //2 正数
        System.out.println(Arrays.toString(str.codePoints().toArray())); //将字符串码点作为流返回，调用toArray存入数组
        System.out.println(str.startsWith("young"));
        System.out.println(str.endsWith("abc"));
        //返回与字符串匹配的第一个字串或字符的位置
        System.out.println(str.indexOf("ng"));
        //字符串的替换
        String newStr = str.replace("y","hhh");
        System.out.println(newStr);
        //返回一个字串
        System.out.println(str.substring(2));
    }
}
