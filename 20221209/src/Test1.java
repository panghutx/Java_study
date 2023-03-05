import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     */
    //3   2   1   5

    public static  int val(int[] n){
        //1.计算n的位数
//        int count=0;
//        int tmp=n;
//        while(tmp>0){
//            count++;
//            tmp/=10;
//        }
        //System.out.println(count);
//        tmp=n;
        if(n.length==0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int count = n.length;
//        //2.将其各位放到数组中
        for (int i = 0; i < count; i++) {
            list.add(n[i]);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //5  0

        System.out.println(list);

        //3.转换成最大的整数
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i)*Math.pow(10,count-1);
            count--;
        }

        return sum;
    }

    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     */
    //3   2   1   5
    public static String count1(int[] nums){
        Integer[] ret = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[i];
        }
        Arrays.sort(ret, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a1 = String.valueOf(o1);
                String a2 = String.valueOf(o2);
                return (a2 + a1).compareTo(a1 + a2);
            }
        });
        //System.out.println(ret);
        if (ret[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ret.length; i++) {
            sb.append(ret[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        int[] nums1 = new int[]{0,55,43,67};
        System.out.println(count1(nums1));
    }

}
