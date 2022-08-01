import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    //去重
    public static String isRepeat(String str){
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),i);
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            System.out.println(isRepeat(str));
        }

    }
}
