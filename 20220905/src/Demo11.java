import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i]=scanner.next();
        }
        int flg1=1;
        int flg2=1;
        for (int i = 0; i < n; i++) {
            if(i+1<n&&ans[i].length()>ans[i+1].length()){
                flg1=0;//不满足按长度排序
                break;
            }
            for (int j = 0; j < ans[i].length(); j++) {
                if(i+1<n&&ans[i].charAt(j)>ans[i+1].charAt(j)){
                    flg2=0;//不满足按字典排序
                    break;
                }
            }
        }

        if(flg1==1&&flg2==1){
            System.out.println("all");
        }else if(flg1==0&&flg2==0){
            System.out.println("none");
        }else if(flg1==1&&flg2==0){
            System.out.println("lengths");
        }else if(flg1==0&&flg2==1){
            System.out.println("lexicographically");
        }
    }
}
