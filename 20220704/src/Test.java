import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static int[] add(int[] nums1,int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int l1=0;
        int l2=0;
        //1.合并一个新数组
        int[] nums = new int[m+n];
        for (int i = 0; i < m+n; i++) {
            if(nums1[l1]<nums2[l2]){
                nums[i]=nums1[l1];
                l1++;
            }else {
                nums[i]=nums2[l2];
                l2++;
            }
        }
        if(m>n){
            for (int i = l1; i < m; i++) {
                nums[i]=nums1[i];
            }
        }else {
            for (int i = l2; i < n; i++) {
                nums[i]=nums2[i];
            }
        }
        return nums;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int l=i+1;
            int r=n-1;
            while(l<r){
                if(nums[l]+nums[r]+nums[i]==0){
                    List<Integer> list = new ArrayList<>();
                    ans.add(Arrays.asList(nums[l],nums[r],nums[i]));
                    //跳过重复元素
                    while(l<r&&nums[l]==nums[l+1]){
                        l++;
                    }
                    while(l<r&&nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(nums[l]+nums[r]+nums[i]<0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums1));

        int[][] array={{1,2,3},{4,5,6}};
        System.out.println(array.length);
    }
}
