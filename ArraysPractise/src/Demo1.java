import java.util.Arrays;

public class Demo1 {
    public static void doubleArr(int[] nums){
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*2;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        doubleArr(nums);
        System.out.println(Arrays.toString(nums));
    }
}
