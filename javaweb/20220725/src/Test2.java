import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            set.add(str);
        }
        int len = set.size();
        System.out.println(len);

    }
}
