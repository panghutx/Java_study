import java.util.Random;

public class Demo1 {
    public static void main(String[] args) {
        //打印1！+2！+3！+4！+5！
        int ret=0;
        for(int j=1;j<=5;j++){

            int sum=1;
            for (int i=1;i<=j;i++){
                //求i的阶乘
                sum*=i;
            }
            ret+=sum;
        }
        System.out.println(ret);
//
//        Random random = new Random();
//        int rand = random.nextInt();


    }
}
