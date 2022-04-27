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
    //1.顺序存储，传入数组和要反转的首位置、尾位置
    public static void reverse(char[] nums,int start,int end){
        //当首位置小于尾位置，交换首位位置对应的元素，首位置+1，尾位置-1，如此往复
        while(start<end){
            char tmp=nums[start]; //临时变量tmp存放start位置的元素
            nums[start]=nums[end-1]; //将末尾end-1位置的元素复制给首位置元素
            nums[end-1]=tmp; //临时变量tmp存放的首位置元素赋值给尾位置
            start++; //首位置+1
            end--; //尾位置-1
        }
    }
    public static void main(String[] args) {
        //1.顺序存储
        char[] nums = {'a','b','c','d','e','1','2','3','4','5'};
        reverse(nums,0,nums.length); //反转整个数组
        reverse(nums,0,5); //反转a到e位置元素[0，5)
        reverse(nums,5,nums.length); //反转1到5位置元素(5,10)
        System.out.println(Arrays.toString(nums)); //打印反转后的结果 1,2,3,4,5,a,b,c,d,e
    }
}
