import java.util.*;
public class Demo15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] array = new int[a];
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a; i++) {
            array[i] = sc.nextInt();
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            int n = map.get(array[i]);
            if (n<=2) {
                list.add(array[i]);
            }

        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int add = 0;
            int mul = 1;
            for (int j = i; j < list.size(); j++) {
                add += list.get(j);
                mul *= list.get(j);
                if (add > mul) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

}
