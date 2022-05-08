public class Demo5 {
    /**
     * 给定一个有序整型数组, 实现二分查找
     */
    public static int binarySearch(int[] nums,int n){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>n){
                right = mid - 1;
            }else if(nums[mid]<n){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(binarySearch(nums, 5));
    }
}
