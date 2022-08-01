import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayListUse {

    public static void removeElement(int[] nums, int val) {

        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
            }
        }

        for (int f = 0; f < nums.length; f++) {
            System.out.println(nums[f]);
        }
    }
    public static void main(String[] args) {
        int[] nums= new int[]{3,2,2,3};
        removeElement(nums, 2);


    }
    public static void main3(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt(); // 行数
        for (int i = 0; i < numRows; i++) {
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i){
                    list1.add(1);
                }else {
                    list1.add(list.get(i-1).get(j)+list.get(i-1).get(j-1));
                }
            }
            list.add(list1);
        }
        System.out.println(list);

    }

    public static void main2(String[] args) {
        //遍历顺序表
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //方法1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //方法2
        for (Integer i:list) {
            System.out.println(i);
        }
        //方法3 迭代器
        Iterator<Integer>iterator = list.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("C++");
        list.add("Java");
        list.add("Python");
        list.add("JavaScript");
        list.add("php");
        System.out.println(list);
        // 获取list中有效元素个数
        System.out.println(list.size());
        // 获取和设置index位置上的元素，注意index必须介于[0, size)间
        System.out.println(list.get(1));
        list.set(1, "JavaWEB");
        System.out.println(list.get(1));
        // 在list的index位置插入指定元素，index及后续的元素统一往后搬移一个位置
        list.add(1, "TypeScript");
        System.out.println(list);
        // 删除指定元素，找到了就删除，该元素之后的元素统一往前搬移一个位置
        list.remove("Python");
        System.out.println(list);
        // 删除list中index位置上的元素，注意index不要超过list中有效元素个数,否则会抛出下标越界异常
        list.remove(list.size()-1);
        System.out.println(list);

        // 查找指定元素第一次出现的位置：indexOf从前往后找，lastIndexOf从后往前找
        list.add("JavaSE");
        System.out.println(list.indexOf("JavaSE"));
        System.out.println(list.lastIndexOf("JavaSE"));
        // 使用list中[0, 4)之间的元素构成一个新的ArrayList返回
        List<String> ret = list.subList(0, 5);
        System.out.println(ret);
        list.clear();
        System.out.println(list.size());
    }
    }

