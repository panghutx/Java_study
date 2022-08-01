import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String output = scanner.next();
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> ret = new HashMap<>();
        for (int i = 0; i < output.length(); i++) {
            char ch = output.toUpperCase().charAt(i);
            map.put(ch,i);
        }
        //将输出结果存入哈希表，将输入结果与它比较，输入结果中不存在的就是坏键盘
        for (int i = 0; i < input.length(); i++) {
            char ch = input.toUpperCase().charAt(i);
            if(!map.containsKey(ch) && !ret.containsKey(ch)){
                ret.put(ch,i);
                System.out.print(ch);
            }
        }
    }
}
