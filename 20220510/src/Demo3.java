public class Demo3 {
    /**
     * 二分查找
     */
    public int binarySearch(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            //每次范围缩小一半
            int mid = (left+right)/2;
            if(nums[mid]<target){ //范围缩小到右半部分
                left = mid + 1;
            }else if(nums[mid]>target){
                right = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        Demo3 demo3 = new Demo3();
        System.out.println(demo3.binarySearch(nums, 4));
        //System.out.println(binarySearch(nums, 4));
    }
}
