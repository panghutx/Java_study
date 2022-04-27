public class Demo1 {

    /**
     * 求和的重载
     * 在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
     */
    public static int sum(int num1,int num2){
        return num1+num2;
    }
    public static double sum(double num1,double num2,double num3){
        return num1+num2+num3;
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 2));
        System.out.println(sum(2.3, 3.2, 6.6));
    }

}
