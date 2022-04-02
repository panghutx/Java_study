class Solution {
    public boolean isPalindrome(int x) {
        //判断一个数的位数
        int count=0;
        int tmp=x;
        while(tmp!=0){
            count++;
            tmp/=10;
        }
        int left=0;
        int right=count-1;
        while(left<right){
            if(x/(int)Math.pow(10,right)%10!=x/(int)Math.pow(10,left)%10){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class Test {
    public static boolean huiwen(int x){
        String rst = new StringBuilder(x+"").reverse().toString();
        return (x+"").equals(rst);
    }
    public static void main(String[] args) {
        //Boolean rst = new Solution().isPalindrome(101);
        //System.out.println(rst);
        //System.out.println(Math.pow(10,0));
        System.out.println(huiwen(101));


    }
}
