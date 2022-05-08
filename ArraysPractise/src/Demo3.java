import java.util.Arrays;

public class Demo3 {
    /**
     * 冒泡排序
     */

    public static void bubbleSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{6,7,4,3,5,9};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
