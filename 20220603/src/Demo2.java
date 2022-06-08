public class Demo2 {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = str1.intern();
        System.out.println(str1==str2);
        String str3 = "hello";
        String str4 = new String("hello");
        System.out.println(str3==str2);
        System.out.println(str4==str3);
    }
}
