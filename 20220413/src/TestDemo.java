import java.util.Arrays;

public class TestDemo {
    //摩尔算法
    public static int majorityElement(int[] nums) {
        int major=0;
        int count=0;
        for(int num:nums){
            if(count==0){
                major=num;
            }
            if(major==num) count++;
            else count--;
        }
        return major;
    }
    //剑指 Offer 56 - II. 数组中数字出现的次数 II
    //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字

    public static int singleNumber(int[] nums) {
        int[] bin = new int[32];
        for(int num:nums){
            for(int i=0;i<32;i++){
                bin[i]+=num&1;
                num = num>>>1;
            }
        }
        //对数组每一位模3
        for(int i=0;i<32;i++){
            bin[i]=bin[i]%3;
        }
        int res = 0;
        for(int i=0;i<32;i++){
            res = res<<1;  //左移1位
            res |= bin[31 - i] % 3;  //恢复第i位的值到res
        }
        return res;



    }

    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0]=3;
        arr[1]=5;
        arr[2]=3;
        arr[3]=3;

        System.out.println(singleNumber(arr));
    }
}
