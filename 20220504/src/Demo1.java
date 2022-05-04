import java.util.Arrays;

public class Demo1 {
    public static int[] singleNumbers(int[] nums) {
        int sum=0;
        int num1=0;
        int num2=0;
        int pos=0;
        for(int num:nums){
            sum^=num;
        }
        //判断sum二进制哪一位是1
        for(int i=0;i<32;i++){
            if(((sum>>i)&1)==1){
                pos=i;
                break;
            }
        }
        //按二进制某一位分组
        for(int n:nums){
            if(((n>>pos)&1)==1){
                num1^=n;
            }
            num2=sum^num1;
        }
        return new int[]{num1,num2};
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,5,2};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
}
