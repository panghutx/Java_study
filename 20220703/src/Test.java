import java.util.HashMap;
import java.util.Map;

public class Test {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start=0;
        int end=0;
        int ans = 0;
        int n=s.length();
        while(end<n){
            if(!map.containsKey((s.charAt(end)))){
                map.put(s.charAt(end),end);
                end++;
            }else {
                ans = Math.max(end - start,ans); //比较哪个值大
                if(map.containsKey(s.charAt(start))){
                    map.remove(s.charAt(start),start);
                }
                start++;

            }
        }
        return ans;

    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.lengthOfLongestSubstring1("abcabcbb"));
    }
}
