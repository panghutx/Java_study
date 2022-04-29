public class Demo2 {

    /**
     * 返回的数字之和
     * 写一个递归方法，输入一个非负整数，返回组成它的数字之和
     * 例如，输入 1729, 则应该返回 1+7+2+9， 它的和是 19
     */

    public static int returnSum(int n){
        int sum=0;
        if(n/10==0){
            return n;
        }
        sum = n%10+returnSum(n/10);
        return sum;
    }

    /**
     * 递归打印数字的每一位
     * 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
     */
    public static void print(int n){
        if(n>9){
            print(n/10);
        }
        System.out.print(n%10);
    }

    public static void main(String[] args) {
        print(1234);
    }
}
