import java.util.Arrays;
import java.util.Scanner;

public class demo14 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int count=0;
        while(n<m){
            n=n+yueshu(n);
            count++;
        }
        if(n==m){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }

    private static int yueshu(int n) {
        for (int i = 2; i < n; i++) {
            if(n%i==0){
                return i;
            }
        }
        return -1;
    }
}
