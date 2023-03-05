import java.util.Map;
import java.util.Scanner;

public class demo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int min=0;
        int i=0;
        while (i<x) {
            if(fib(i)<x&&fib(i+1)>x){
                min = Math.min(x-fib(i),fib(i+1)-x);
                break;
            }else if(fib(i)==x){
                min=0;
                break;
            }else{
                i++;
            }
        }

        System.out.println(min);
    }
    public static int fib(int n){
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

}
