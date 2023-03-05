
import java.util.Scanner;

public class Demo4 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] ret = input.split(" ");

        reverse1(ret,0,ret.length-1);

        String ans="";
        for (int i = 0; i < ret.length; i++) {

            if(i==ret.length-1){
                ans=ans+ret[i];
            }else{
                ans=ans+ret[i]+" ";
            }
        }
        System.out.println(ans);

    }

    private static void reverse1(String[] num, int start, int end) {
        while(start<end){
            String tmp = num[start];
            num[start]=num[end];
            num[end]=tmp;
            start++;
            end--;
        }
    }
}
