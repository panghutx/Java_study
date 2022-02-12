public class Test {
    //装箱和拆箱
    //简单类---》包装类   装箱
    //包装类---》简单类   拆箱
    public static void main(String[] args) {
        Integer a=200;
        Integer b=200;
        System.out.println(a==b);
    }
    public static void main2(String[] args) {
        Integer a=10;
        int b=a;
        int c=a.intValue();
        System.out.println(b);
        System.out.println(c);
    }
    public static void main1(String[] args) {
        int i=10;
        Integer a=i;
        Integer b=Integer.valueOf(i);
        System.out.println(b);
        System.out.println(a);
    }
}
