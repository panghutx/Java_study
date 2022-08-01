import java.util.Arrays;

public class Sort {
    /**
     * 直接插入排序
     * @param nums
     * @return
     */
    public int[] straightInsertSort(int[] nums){
        if(nums.length<=1){
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i-1;
            for (; j >=0 ; j--) {
                if(tmp<nums[j]){
                    nums[j+1]=nums[j];
                }else {
                    break;
                }
            }
            nums[j+1]=tmp;
        }
        return nums;
    }

    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    /**
     * 直接选择排序
     * @param nums
     */

    public void straightSelectSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                minIndex = nums[minIndex]<nums[j]?minIndex:j;
            }
            //交换
            swap(nums,i,minIndex);
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] nums= {3,4,1,6,2};
        sort.straightSelectSort(nums);


    }
}
