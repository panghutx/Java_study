import java.util.*;
public class Demo18{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

            int n = sc.nextInt();//剩下的瓶子树
            int num=0;//换到的瓶子数
            int count=0;
            if(n==0){
                break;
            }
            while(n/3!=0){
                num=n/3;
                n=n%3;
                n+=num;
            }
            if(n==2){
                num++;
            }
            System.out.println(num);
        }
    }
}
