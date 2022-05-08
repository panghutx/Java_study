import java.util.Arrays;

public class Demo4 {
    /**
     * 给定一个整型数组, 判定数组是否有序（递增）
     */
    public static boolean isOrder(int[] nums){
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(tmp);
        return Arrays.equals(nums,tmp);
    }

    public static void main(String[] args) {
        //int[] nums=new int[]{4,3,6,5,4};
        int[] nums = new int[]{1,2,3,4};
        System.out.println(isOrder(nums));
    }
}
