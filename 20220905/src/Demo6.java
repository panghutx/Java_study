import java.util.Scanner;

public class Demo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b= scanner.nextLine();
        int n=a.length();
        int count=0;
        for (int i = 0; i <=n ; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(a,0,i);
            stringBuilder.append(b);
            stringBuilder.append(a,i,n);

            if(huiwen(stringBuilder)){
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean huiwen(StringBuilder stringBuilder) {
        String s = stringBuilder.toString();
        String s1 = stringBuilder.reverse().toString();
        return s.equals(s1);
    }
}
