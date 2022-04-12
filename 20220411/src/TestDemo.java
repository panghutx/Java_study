import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {
    public static int Fib(int i){
        if(i<2) return i;
        return Fib(i-1)+Fib(i-2);
    }
    public static int Fib1(int n){
        int a=0;int b=1;int c=1;
        for(int i=0;i<n;i++){
            a=b;
            b=c;
            c=a+b;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        int n = scanner.nextInt();
        //本质还是求斐波那契
        int[] arr=new int[100];
        for(int i=0;i<100;i++){
            arr[i]=Fib1(i);
        }
        //要输入的数
        int n=19;
        //要走的步数
        int count=0;
        for(int j=0;j<100;j++){
            if(arr[j]==n) count=0;
            else if(j-1>=0&&n>arr[j-1]&& n<arr[j]) count=(arr[j]-n)<(-(n-arr[j]))?(arr[j]-n):(-(n-arr[j]));
        }
        //System.out.println(Arrays.toString(arr));
        System.out.println(count);
        //给了一个数  19


    }
}
