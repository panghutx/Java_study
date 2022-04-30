public class Demo1 {
    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */

    /**
     *暴力解法，时间复杂大O(N^2)
     * 空间复杂度O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] newNum = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    newNum[0]=i;
                    newNum[1]=j;
                    break;
                }
            }
        }
        return newNum;
    }

}
