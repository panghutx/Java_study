import java.util.Arrays;

public class Demo6 {
    /**
     * 实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
     */

    public static int[] myCopyOf(int[] nums){
        int[] newNum = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            newNum[i]=nums[i];
        }
        return newNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(myCopyOf(nums)));
    }
}
