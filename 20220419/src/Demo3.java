import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 移动0,将0移到数组末尾
 * User: panghu
 * Date: 2022-04-19
 * Time: 20:56
 */
public class Demo3 {
    public static void moveZeroes(int[] nums) {
        //定义两个变量，i和j
        //当j下标元素不为0，替换i下标元素为j下标元素  i和j自增
        //当j下标元素为0，不替换，j自增
        //遍历结束，将i到n-1下标元素置为0
        int n =nums.length;
        int i=0;
        for(int j=0;j<n;j++){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
        }
        while(i<n){
            nums[i++]=0;
        }

    }
        public static void main(String[] args) {
            int[] nums =new int[]{0,1,0,3,12};
            moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        }
}
