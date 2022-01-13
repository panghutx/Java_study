import java.util.Scanner;

public class TestDemo {
    public static int func(int n) {
        int n1=1;
        int n2=1;
        int n3=1;
        for(int i=3;i<=n;i++) {
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }
        return n3;
    }
    public static void main(String[] args) {
        System.out.println(func(1));
    }
}

