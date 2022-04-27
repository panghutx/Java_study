public class Demo3 {
    /**
     * 找出出现一次的数字
     * 有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
     */

    public static int onlyOne(int[] nums){
        int sum=0;
        for(int num:nums){
            sum ^= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,4,4};
        System.out.println(onlyOne(nums));
    }
}
