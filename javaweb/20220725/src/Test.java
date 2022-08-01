import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int ans = fib(num);
        System.out.println(ans);


    }
    public static int fib(int num){

        int[] fib = new int[1000000];
        fib[0]=0;
        fib[1]=1;
        int i=0;
        for (i = 2; i < num; i++) {
            fib[i]=fib[i-1]+fib[i-2];
            if(fib[i]>num){
                break;
            }

        }
        return Math.min(Math.abs(fib[i]-num),Math.abs(fib[i-1]-num));
    }
}
