public class Demo4 {
    /**
     * 求最大值方法的重载
     * 在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
     */

    public static int maxVal(int num1,int num2){
        return num1>num2 ? num1 : num2;
    }
    public static double maxVal(double num1,double num2){
        return num1>num2 ? num1 : num2;
    }
    public static double maxVal(double num1,double num2,int num3){
        double num4 = maxVal(num1,num2);
        return num4>num3 ? num4 : num3;
    }

    public static void main(String[] args) {
        System.out.println(maxVal(3, 6));
        System.out.println(maxVal(4.5, 1.2));
        System.out.println(maxVal(3.2, 6.7, 5));

    }
}
