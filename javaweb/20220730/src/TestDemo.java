import java.util.*;

public class TestDemo {

    /**
     * top-k问题
     * 求第k个大的元素
     * 1.建立一个小根堆（放进k个元素）
     * 2.将剩余元素与堆顶元素比较，大于堆顶元素就弹出堆顶元素，入堆
     * 3.遍历完剩余元素后，此时的堆就是前k个最大的元素
     * 4.依次出堆，最后一个出来的就是第k大的元素
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int top= priorityQueue.peek();
            if(nums[i]>top){
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.poll();
    }

    /**
     * 搜索旋转排序数组
     */
    public int search(int[] nums, int target) {
        return 1;
    }

    /**
     * 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][];
        }
        //按start的值来升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(merged.size()==0||start>merged.get(merged.size()-1)[1]){
                merged.add(new int[]{start,end});
            }else{
                merged.get(merged.size()-1)[1] = Math.max(end,merged.get(merged.size()-1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 在排序数组中查找数字
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int left = binarySearch(nums,target,true);
        int rigth = binarySearch(nums,target,false)-1;
        if(rigth>=left&&rigth<nums.length&&nums[left]==target&&nums[rigth]==target){
            return rigth-left+1;
        }
        return 0;

    }
    public int binarySearch(int[] nums,int target,boolean flg){
        int n=nums.length;
        int l=0;
        int r=n-1;
        int ans=n;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>target||(flg&&nums[mid]>=target)){
                r=mid-1;
                ans=mid;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        //int[] nums={3,2,1,5,6,4};
        int[][] nums={{1,3},{2,6},{8,10},{15,18}};
        for (int[] num:nums) {
            System.out.println(Arrays.toString(num));
        }
    }
}
