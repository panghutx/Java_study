import java.util.Arrays;

public class Demo1 {
    /**
     * 斐波那契数列
     * 获取斐波那契数列的前n项
     * 0 1 1 2 3 5 8 13 21 34 55
     */
    public static int[] fib(int n){
        if(n<=0){
            return null;
        }
        if(n==1){
            return new int[]{0};
        }
        int[] nums = new int[n];
        nums[0]=0;
        nums[1]=1;
        for(int i=2;i<n;i++){
            nums[i]= nums[i-1]+nums[i-2];
        }
        return nums;
    }

    /**
     * 获取斐波那契数列的第n项
     */

    public static int fib1(int n){
        int a=0;
        int b=1;

        for(int i=2;i<n;i++){
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] rst = fib(2);
        System.out.println(Arrays.toString(rst));
        System.out.println(fib1(7));
    }
}
