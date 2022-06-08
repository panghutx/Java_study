public class Search {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        //System.out.println(sequentialSearch(nums, 2));  //顺序查找
        System.out.println(myBinarySearch(nums, 6));  //二分查找
    }
    /**
     * 二分查找
     * 取中间值作为比较对象，中间值大于查找值，在中间值左边查找，否则在右边查找
     */
    public static int myBinarySearch(int[] nums,int val){
        int left=0; //左下标
        int right=nums.length; //右下标
        while(left<right){
            int mid = (left+right)/2; //中间值下标
            if(nums[mid]<val){
                left = mid +1; //从右半部分开始找
            }else if(nums[mid]>val){
                right = mid -1;  //从左半部分开始找
            }else {
                return mid; //找到返回下标值
            }
        }
        return -1; //没找到返回-1
    }
    /**
     * 顺序查找
     * 从数组开头开始查找，找到val返回下标。没找到返回-1
     */
    private static int sequentialSearch(int[] nums,int val) {
        for(int i=0;i<nums.length;i++){  //从0下标开始查找
            if(nums[i]==val){
                return i;  //找到返回i下标
            }
        }
        return -1; //没找到返回-1
    }
}
