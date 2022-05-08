import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo2 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
     */
    public static int[] Target(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,9,7,3,6};
        int[] rst = Target(nums,5);
        System.out.println(Arrays.toString(rst));
    }

}
