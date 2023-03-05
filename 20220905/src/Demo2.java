import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        Long x=0l;
        for (int i = 0; i < 3*a; i++) {
            x=scanner.nextLong();
            list.add(x);
        }
        System.out.println(maxVal(list, 0));


    }

    private static int maxVal(List<Long> list,int ret) {
        for (int i = 0; i < list.size(); i+=3) {
            long[] num = new long[3];
            for (int j = 0; j < 3; j++) {
                num[j]=list.get(i+j);
            }
            Arrays.sort(num);
            ret+=num[1];
        }
        return ret;
    }

}
