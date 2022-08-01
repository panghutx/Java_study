import java.util.*;

public class Test2 {
    List<String> ans = new ArrayList<>();
    List<String> tmp = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s,ans,tmp,-1);
        return ans;
    }
    public void dfs(String s, List<String> ans, List<String> tmp,int index){
        if(index==s.length()||tmp.size()==5){
            if(index==s.length()){
                ans.add(String.join(".",tmp));
            }
            return;
        }
        for(int i=1;i<4;i++){
            String x = s.substring(index+1,i);
            if(Integer.parseInt(x)<256 && (x.equals("0") || !x.startsWith("0"))){
                tmp.add(x);
                dfs(s,ans,tmp,index+i);
                tmp.remove(tmp.size()-1);

            }
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {

        int n=temperatures.length;
        for(int i=0;i<n-1;i++){
            if(temperatures[i]<temperatures[i+1]){
                temperatures[i]=1;
            }else{
                boolean flg =false;
                for(int j=i+2;j<n;j++){
                    if(temperatures[i]<temperatures[j]){
                        temperatures[i]=j-i;
                        flg=true;
                        break;
                    }
                }
                if(!flg){
                    temperatures[i]=0;
                }

            }

        }
        temperatures[n-1]=0;
        return temperatures;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] nums = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(test2.dailyTemperatures(nums)));

    }
}
