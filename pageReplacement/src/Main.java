import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        scanner.next()
        int num=10;
        int[] page = new int[num];
        for (int i = 0; i < num; i++) {
            Random random = new Random();
            page[i]=random.nextInt(10);
        }
        int num2=3;
        int[] block = new int[num2];

        //
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num2; j++) {
                if(page[i]==block[j]){
                    //没有缺页
                    break;
                }
            }
            //3个物理块都遍历完，没有页数，缺页

        }
    }
}
