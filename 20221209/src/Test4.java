public class Test4 {
    /**
     * 输入一个字符串，比如“abcbaccc”，返回这个字符串中的最长回文子串
     */
    public static int val(String str){
        int len = str.length();
        int[][] dp = new int[len+1][len+1];
        for (int i = len-1;i>=0; i--) {
            dp[i][i]=1;
            for (int j = i+1; j < len; j++) {
                if(dp[i]==dp[j]){
                    dp[i][j]=dp[i-1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        String str="abcbaccc";
        System.out.println(val(str));
    }
}
