import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int max = a*b;
        for (int i = 1; i <= max; i++) {
            if(i%a==0&&i%b==0){
                System.out.println(i);
                break;
            }
        }
    }
}
