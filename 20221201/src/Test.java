import java.util.*;

public class Test {
    public static void main1(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("java",100);
        map.put("计算机网络",94);
        map.put("操作系统",99);
        System.out.println(map);
        System.out.println(map.get("java"));
        System.out.println(map.containsKey("java"));
        System.out.println(map.getOrDefault("fdfd", null));
        Set<String> strings = map.keySet();
        System.out.println(strings);
        Collection<Integer> values = map.values();
        System.out.println(values);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String,Integer> entry:entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }

    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(13);
        System.out.println(set);
        //set.clear();
        //System.out.println(set);
        List<Integer> list  = new LinkedList<>();
        list.add(1);
        list.add(12);
        set.addAll(list);
        System.out.println(set);
        final Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Object[] objects = set.toArray();
        for (Object elem:objects) {
            System.out.println(elem);
        }
    }

    public static void main(String[] args) {





    }
}
