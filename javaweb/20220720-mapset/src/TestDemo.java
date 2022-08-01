import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestDemo {

        public static  int[] singleNumber(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int num:nums){
                if(!map.containsKey(num)){
                    map.put(num,1);
                }else {
                    map.put(num,map.get(num)+1);
                }
            }
            int[] ret = new int[2];
            for(int num:nums){
                int i=0;
                if(map.get(num)==1){
                    ret[i]=num;
                    i++;
                }
            }
            return ret;
        }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

}
