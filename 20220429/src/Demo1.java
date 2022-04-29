public class Demo1 {
    /**
     * 斐波那契数
     * 求斐波那契数列的第n项。(迭代实现)
     */
    public static int fib(int n){
        int a=0;
        int b=1;
        int c=1;
        if(n==0) {
            return 0;
        }else {
            for(int i=1;i<n;i++){
                a=b;
                b=c;
                c=a+b;
            }
            return b;
        }
    }

    /**
     *递归求斐波那契数列的第 N 项
     */
    public static int fib1(int n){
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fib1(6));
    }
}
