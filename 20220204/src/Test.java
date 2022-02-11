import java.util.*;

public class Test {
    //Map
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.put("姓名","panghu");
        map.put("年龄","18");
        System.out.println(map.get("panghutx"));
        System.out.println(map.getOrDefault("panghutx", "panghutx"));

        System.out.println(map);
    }
    //Collection
    public static void mai2n(String[] args) {
        Collection<String> list = new LinkedList<>();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add("xiaofu");
        list.add("panghu");

        System.out.println(list.size());
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(list);
    }
    public static void main1(String[] args) {
        int i=0;
        while(i<10){
            try{
                if(i<10){
                    i++;
                    throw new Exception("123");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
