import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test2 {
    public static void bobbleSort(int[] ret){
        for (int i = 0; i < ret.length-1; i++) {
            for (int j = 0; j < ret.length-1-i; j++) {
                //比较
                if(ret[j]>=ret[j+1]){
                    swap(ret,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] ret,int l,int r){
        int tmp=ret[l];
        ret[l]=ret[r];
        ret[r]=tmp;
    }

    public static void main1(String[] args) {
        int[] ret1=new int[]{8,5,4,22};
        int[] ret2=new int[]{0,33,5,4,22};
        int[] ret3=new int[]{};
        int[] ret4=new int[]{1,2,5,8,12};
        int[] ret5=new int[]{22,6,4,3};
        bobbleSort(ret1);
        System.out.println(Arrays.toString(ret1));
        bobbleSort(ret2);
        System.out.println(Arrays.toString(ret2));
        bobbleSort(ret3);
        System.out.println(Arrays.toString(ret3));
        bobbleSort(ret4);
        System.out.println(Arrays.toString(ret4));
        bobbleSort(ret5);
        System.out.println(Arrays.toString(ret5));
    }
    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * [-2,1,-3,4,-1,2,1,-5,4]
     *        2
     */
    public static int max(int[] ret){
        int sum=ret[0];
        int pre=0;
        for (int i = 0; i < ret.length; i++) {
            pre = Math.max(ret[i],pre+ret[i]);
            sum=Math.max(pre,sum);
        }
        return sum;
    }

    /**
     * (((()))
     *
     */
    public static int count(String str){
        Stack<Character> stack = new Stack<>();
        final char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='('||chars[i]=='['||chars[i]=='{'){
                stack.push(chars[i]);
            }
        }
        return stack.size();
    }

    static List<String> list = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        dfs(0,0,"",n);
        return list;
    }
    public static void dfs(int l,int r,String s,int n){
        if(l==n&&r==n){
            list.add(s);
            return;
        }
        if(l<n){
            dfs(l+1,r,s+"(",n);
        }
        if(r<n&&r<l){
            dfs(l,r+1,s+")",n);
        }

    }

    public static void main(String[] args) {
        //System.out.println(generateParenthesis(2));
        int[] ret = new int[]{-1,2,3,-2};
        System.out.println(max(ret));
    }

    public static void main2(String[] args) {
        System.out.println(count("((()))"));
        System.out.println(count("[({})]"));
        System.out.println(count(""));
        System.out.println(count("[{({})}]"));
        System.out.println(count("([]"));
    }

}
