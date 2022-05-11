import java.util.Arrays;

public class Demo2 {
    /**
     * 探讨深拷贝和浅拷贝
     * 1.浅拷贝：改变原数组中的值，新数组也会受影响。
     * 当数组中存放的是基本数据类型，深拷贝和浅拷贝没有影响。
     * 2.深拷贝：新旧数组已毫无关系，改变原数组中的值，新数组不会受到影响
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] newNum;
        newNum = Arrays.copyOf(nums,nums.length);
        nums[1]=100;
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(newNum));
    }
}
