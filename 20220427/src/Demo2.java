import java.util.Scanner;

public class Demo2 {
    /**
     * 求阶乘和
     * 求1！+2！+3！+4！+........+n!的和
     */

    //求一个数的阶乘
    public static int factor(int n){

        if(n==1){
            return 1;
        }
        return n*factor(n-1);
    }

    //求阶乘和
    public static int sumFactor(int n){
        int sum=0;
        for(;n>0;n--){
            sum+=factor(n);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumFactor(5));
    }
}
