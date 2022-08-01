import java.util.*;

public class Test {
    public static void main1(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        //插入节点
        int nums[] = {5,3,4,1,7,8,2,6,0,9};
        for (int i = 0; i < nums.length; i++) {
            binarySearchTree.insert(nums[i]);
        }
        //查找节点
        System.out.println(binarySearchTree.search(10));
        binarySearchTree.remove(3);
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new TreeMap<>();
        int[] nums = {6,5,6,8,10};
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        System.out.println(map);
        System.out.println("============");
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> entry : set){
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
        System.out.println("===============");
        Collection<Integer> collection = map.values();
        System.out.println(collection);
        Set<Integer> setKey = map.keySet();
        System.out.println(setKey);
        Set set1 = new HashSet();
    }
}
