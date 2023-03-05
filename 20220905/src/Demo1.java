import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        Set<Character> set  = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        //String a = scanner.nextLine();
        //String b = scanner.next();
        String a="abc cca";
        String b = "c";

        //将b字符串存入map
        for (int i = 0; i < b.length(); i++) {
            set.add(b.charAt(i));
        }
        //删除重复元素
        int len=a.length();
        for (int i = 0; i < len; i++) {
            if(!set.contains(a.charAt(i))){
                stringBuilder.append(a.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());

    }
}
