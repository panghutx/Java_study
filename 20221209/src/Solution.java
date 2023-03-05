import java.text.DecimalFormat;

public class Solution {
    /**
     * 做一道算法题把，用java手写出一个求算法平方根的方法类似于Math.sqrt，
     * 但是要接受的是double，保留小数点后6位。刚开始有点懵，
     * 后面用二分不断逼近。
     * @param
     * @return
     */

    public static String mySqrt(int num) {

        double left = 0;
        double right = num;
        while (left < right) {
            double middle = (left + right) / 2.0;
            if (Math.abs(middle * middle - num) <= 0.000001) {
                return String.format("%.6f",middle);
            }
            if (middle * middle < num ) {
                left = middle;
                right = num / middle;
            } else if (middle * middle > num ) {
                right = middle;
                left = num / middle;
            }
        }
        return String.format("%.6f",left);
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2));
    }

    public static void main1(String[] args) {
        double d = 114.145;
        DecimalFormat df = new DecimalFormat("#.00");
        String str = df.format(d);
        System.out.println(str);


    }

    public static void main2(String[] args) {
        double d = 1.31111;
        final String format = String.format("%.6f",d);
        System.out.println(format);
    }
}