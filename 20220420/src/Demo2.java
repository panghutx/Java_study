import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 两数之和   暴力枚举
 * 还有一个方法，哈希表，能将时间复杂度从O(N^2)降到1
 * User: panghu
 * Date: 2022-04-20
 * Time: 15:10
 */
public class Demo2 {
    public static int[] twoSum(int[] nums, int target) {
        //int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
/*                    result[0]=i;
                    result[1]=j;
                    break;*/
                    return new int[]{i,j};
                }
            }
        }
        //return result;
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
