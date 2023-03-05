import java.util.Arrays;

class Solution1 {
    public static int[] sortArray(int[] nums) {
        int right=nums.length-1;
        sortArray1(nums,0,right);
        return nums;
    }
    public static void sortArray1(int[] nums,int left,int right) {
        if(left>=right){
            return;
        }
        int basis = find(nums,left,right);
        sortArray1(nums,left,basis-1);
        sortArray1(nums,basis+1,right);
    }
    public static int find(int[] nums,int left,int right){
        int tmp = nums[left];
        while(left<right){
            //从右侧找小于tmp的值
            while(left<right&&nums[right]>=tmp){
                right--;
            }
            nums[left]=nums[right];
            //从左侧找大于tmp的值
            while(left<right&&nums[left]<=tmp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=tmp;
        return left;
    }

    public static void main(String[] args) {
        int[] ret = new int[]{5,2,3,1};
        final int[] ints = sortArray(ret);
        System.out.println(Arrays.toString(ints));
    }
}