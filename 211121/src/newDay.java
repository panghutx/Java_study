import java.util.Scanner;
import java.util.Random;
public class newDay {

    //求出1-6位数的自幂数
//    public static void main(String[] args) {
//        int count=0;
//        int n=0;
//        for(n=1;n<=999999;n++){
//            int temp=n;
//            int sum=0;
//
//            //判断位数
//            while(temp!=0){
//                count++; //2
//                temp=temp/10;
//            }
//            //求自幂数
//            temp=n;
//
//            while(temp!=0){
//                sum += Math.pow(temp%10,count);
//                temp=temp/10;
//            }
//            //判断是否相等
//            if(n==sum){
//                System.out.println(n);
//            }
//        }
//    }


    //编写程序数一下1到100的所有整数中出现多少个数字9
    //9 19 29 ……89 91 92 93 …… 99
//    public static void main(String[] args) {
//        int i=0;
//        int count=0;
//        for(i=1;i<=100;i++){
//            if(i%10==9||i/10==9){
//                count++;
//                System.out.println(i);
//            }
//
//
//        }
//        System.out.println(count);
//    }

    //计算1/1-1/2+1/3……+1/99-1/100的值
//    public static void main(String[] args) {
//        int i=1;
//        float sum=0;
//        for(i=1;i<=100;i++){
//
//            if(i%2==0){
//                sum-=1.0/i;
//            }else{
//                sum+=1.0/i;
//            }
//        }
//        System.out.println(sum);
//    }
    //求两个数的最大公约数

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int a=scan.nextInt();
//        int b=scan.nextInt();
//        int c=b;
//        while(a%b!=0) {
//            c=a%b;
//            a=b;
//            b=c;
//        }
//        System.out.println("最大公约数是"+c);
//    }


    //打印99乘法表
//    public static void main(String[] args) {
//        int i=0;
//        int j=0;
//        for(i=1;i<10;i++){
//            for(j=1;j<=i;j++){
//                System.out.print(j+"*"+i+"="+j*i+" " );
//            }
//            System.out.println();
//        }
//    }
    //输出1000-2000之间的所有闰年
//    public static void main(String[] args) {
//        for(int i=1000;i<=2000;i++){
//            if(i%4==0&&i%100!=0||i%400==0){
//                System.out.println(i+"是闰年");
//            }
//        }
//    }

    //打印1-100以内的所有素数
//    public static void main(String[] args) {
//        int j=2;
//        int i=2;
//        for(j=2;j<=100;j++){
//            for(i=2;i<=Math.sqrt(j);i++){ //!记住：必须是>=
//                if(j%i==0){
//                    System.out.println(j+"不是素数");
//                    break;
//                }
//            }
//            if(i>Math.sqrt(j)){
//                System.out.println(j+"是素数");
//            }
//        }
//    }


    //判断一个数是否为素数
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int i=0;
//        for(i=2;i<n;i++){
//            if(n%i==0) {
//                break;
//            }
//        }
//        if(i==n){
//            System.out.println(n+"是素数");
//        }



//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        switch(num){
//            case 1:
//                System.out.println("星期一");
//                break;
//            case 2:
//                System.out.println("星期二");
//                break;
//            default:
//                System.out.println("好好学习");
//                break;
//        }
//    }
//    public static void main(String[] args){
//        //创建对象
//        Random random = new Random();
//        Scanner sc = new Scanner(System.in);
//        int rd = random.nextInt(10);
//        while(true){
//            //实例化
//            int num=sc.nextInt();
//
//            if(num<rd){
//                System.out.println("小了");
//            }else if(num>rd){
//                System.out.println("大了");
//            }else{
//                System.out.println("恭喜你猜对了！");
//            }
//        }
//
//    }
}
