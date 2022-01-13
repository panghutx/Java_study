import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        //递归求 1 + 2 + 3 + ... + 10
        System.out.println(func2(10));

    }
    public static int func2(int i){

        if(i==1){
            return 1; //终止条件
        }
        return i+func2(i-1); //递推公式

    }
    public static void func1(int i){
        if(i>9){
            func1(i/10);
        }
        System.out.print(i%10);

    }
    public static void main7(String[] args) {

        //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
        int i=1234;
        func1(1234);
    }

    public static void swap1(int[] arr){
        int tmp=arr[0];
        arr[0]=arr[1];
        arr[1]=tmp;
    }
    public static void main6(String[] args) {
        //交换两个整数的正确方法
        int[] arr={10,20};
        swap1(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int x,int y){
        int tmp=x;
        x=y;
        y=tmp;
    }
    public static void main5(String[] args) {
        //交换两个整型变量的错误演示
        int a=10;
        int b=20;
        swap(a,b);
        System.out.println(a);
        System.out.println(b);
    }
    public static int func(int i){
        if(i==1){
            return 1;
        }else{
            return i*func(i-1);
        }

    }
    public static void main4(String[] args) {
        //计算一个数的阶乘
        int sum=0;
        for (int i = 1; i < 6; i++) {

            sum+= func(i);
        }
        System.out.println(sum);

    }
    public static void main3(String[] args) {
        //求出1-6位数的自幂数
        int i=1;
        for(i=1;i<=9999999;i++) {
            int count=0;
            int tmp=i;
            int sum=0;
            //判断位数
            while(tmp!=0){
                count++;
                tmp/=10;
            }
            tmp=i;
            //得到密数之和
            while(tmp!=0){
                sum+=Math.pow(tmp%10,count);
                tmp/=10;
            }
            if(sum==i){
                System.out.println(i);
            }
        }

    }
    public static void main2(String[] args) {

        //打印100以内的所有素数
        for (int i = 2; i <= 100; i++) {
            int j=0;
            for (j = 2; j <=Math.sqrt(i); j++) {
                if(i%j==0){
                    break;
                }
            }
            if(j>Math.sqrt(i)){
                System.out.println(i);
            }

        }
    }
    public static void main1(String[] args) {
        //判断一个数是否为素数
        Scanner scanner = new Scanner(System.in);
        int scanf=scanner.nextInt();
        int i=0;
        for(i=2;i<=Math.sqrt(scanf);i++){
            if(scanf%i==0){
                System.out.println(scanf+"不是素数");
                break;
            }
        }
        if(i>Math.sqrt(scanf)){
            System.out.println(scanf+"是素数");

        }
    }
}
