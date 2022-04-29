public class Demo3 {
    /**
     * 递归求和
     * 递归求 1 + 2 + 3 + ... + 10
     */
    public static int sum(int n){
        if(n==1){
            return 1;
        }
        return sum(n-1)+n;
    }

    public static void main(String[] args) {
        System.out.println(sum(4));
    }
}
