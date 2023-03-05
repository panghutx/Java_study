import java.util.Arrays;

public class Test3 {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i=0;
        for(;i<v1.length&&i<v2.length;i++){
            int k1 = Integer.parseInt(v1[i]);
            int k2 = Integer.parseInt(v2[i]);
            if(k1>k2){
                return 1;
            }else if(k1<k2){
                return -1;
            }
        }
        //v1长一些
        while(i<v1.length){
            int k1 = Integer.parseInt(v1[i]);
            if(k1!=0){
                return 1;
            }
            i++;
        }
        //v2长一些
        while(i<v2.length){
            int k2 = Integer.parseInt(v2[i]);
            if(k2!=0){
                return -1;
            }
            i++;
        }
        return 0;
    }

    public static void main1(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.01.1", "1.001"));
        System.out.println(compareVersion("1.0","1.0.0"));
    }

    public static void ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        swap(chars,0,str.length()-1);
        int right=0;
        int left=0;
        for (int i=0;i<chars.length;i++){
            if(chars[i]!=' '){
                right++;
            }else{
                swap(chars,left,right-1);
                left=right+1;
                right++;
            }
        }
        swap(chars,left,str.length()-1);
        System.out.println(new String(chars));
    }

    private static void swap(char[] ret, int l, int r) {
        while(l<=r){
            char tmp = ret[l];
            ret[l]=ret[r];
            ret[r]=tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String str = "I like China.";
        ReverseSentence(str);
    }
}
