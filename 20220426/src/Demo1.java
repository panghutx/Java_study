import java.util.Arrays;

/**
 * Change the characters’s order of the list without additional memory space.
 *
 *      Pre：   (a1,a2,…an-1,an,b1,b2,…bm-1,bm)
 *
 *     Post：  (b1,b2,…bm-1,bm, a1,a2,…an-1,an)
 *
 * Try your best to write the functions:
 *
 * The first is to implement it with sequential technique.
 *
 * The second is to implement it with liked technique.
 */
public class Demo1 {
    //1.顺序存储
    public static void reverse(char[] nums,int start,int end){
        while(start<end){
            char tmp=nums[start];
            nums[start]=nums[end-1];
            nums[end-1]=tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        //1.顺序存储
        char[] nums = {'a','b','c','d','e','1','2','3','4','5'};
        reverse(nums,0,nums.length);
        reverse(nums,0,5);
        reverse(nums,5,nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
