/**
 * Created with IntelliJ IDEA.
 * Description: 验证回文串
 * 一、时间复杂度O(n) 空间复杂度O(n)
 * 方法1：左右指针遍历，先将不合规的字符掠过，比较合规字符的左右指针是否相等
 * 方法2：调用API Character.isLetterOrDigIt,将符合的丢尽StringBuilder，然后再左右指针遍历对应位置是否相等
 * 方法3.调用API Character.isLetterOrDigit，将符合的丢尽StringBuilder，然后再调用StringBuilder(str).reverse()
 *       比较两者是否相等
 * 二、空间复杂度O(1)
 * 在原字符串上之间判断，不申请额外空间，想我写的那样，但是别放进数组，直接用charAr()判断就行了
 * User: panghu
 * Date: 2022-04-21
 * Time: 19:48
 */
public class Demo1 {
    public static boolean isPalindrome(String s) {
        String newS = s.toLowerCase();
        char[] nums= newS.toCharArray();
        int left=0;
        int right=nums.length-1;
        while(left<right){
            //先处理特殊字符
            /**
             * 这里尤其注意！！！
             * 要判断left<right,否则会越界
             */
            while(left<right&& (nums[left]<97||nums[left]>122) && !(Character.isDigit(nums[left]))){
                left++;
            }
            while(left<right&& (nums[right]<97||nums[right]>122) && !(Character.isDigit(nums[right]))){
                right--;
            }
            //处理完特殊字符，比较前后是否相等
            if(nums[left]==nums[right]){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
}
