public class Demo7 {
    /**
     * 实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
     */
    public static String myToString(int[] nums){
        String sum = "[";
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1){
                sum = sum + nums[i] + "]";
            }else {
                sum = sum + nums[i] + ",";
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(myToString(nums));
    }
}
