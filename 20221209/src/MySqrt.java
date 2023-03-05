import java.util.*;

public class MySqrt {
    public static String sqrt(int n){
        double left=0;
        double right=n;
        while(left<=right){
            double mid = left+(right-left)/2.0;
            if(Math.abs(mid*mid-n)<=0.000001){
                return String.format("%.6f",mid);
            }else if(mid*mid<n){
                left=mid;
                right=n/mid;
            }else{
                right=mid;
                left=n/mid;
            }
        }
        return String.format("%.6f",left);
    }


    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void count(String str){
        final char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        final Set<Character> characters = map.keySet();
        final Iterator<Character> iterator = characters.iterator();
        List<Character> list = new ArrayList<>();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(map.get(o1)>map.get(o2)){
                    return 1;
                }else if(map.get(o1)==map.get(o2)){
                    return o1-o2;
                }else{
                    return -1;
                }
            }
        });

        System.out.println(list);

    }


    public static void main(String[] args) {
        //System.out.println(sqrt(2));
        count("aabbbbcdd");
    }
}
