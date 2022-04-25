import java.util.Scanner;

public class Demo1 {

    /**
     * 打印1个99乘法表
     */
    public static void multiply(){
        //i代表行数  i=1就是第1行
        //j代表列数  j<=i  第i行就有j列
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+j*i+" ");
            }
            System.out.println();
        }
    }

    /**
     * 模拟登录
     * 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,
     * 密码错误， 可以重新输 入，最多输入三次。三次均错，则提示退出程序
     */
    public static void login(){
        String correctPass = "zzz123";
        int count = 2;
        System.out.println("请输入密码");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        while(count!=0){
            if(password.equals(correctPass)){
                System.out.println("登陆成功");
                break;
            }else {
                System.out.println("密码错误，请重新输入");
                password = scanner.next();
                count--;
            }
        }
        if(count==0){
            System.out.println("机会用尽，退出程序");
        }

    }

    /**
     * 水仙花数
     * 求出0～999之间的所有“水仙花数”并输出。
     * (“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 身，
     * 如；153＝1＋5＋3?，则153是一个“水仙花数“。）
     */

    //求0~999之间的所有水仙花数
    public static void allNarcissusNumber(){
        for(int i=100;i<1000;i++){
            narcissusNumber(i);
        }
    }
    public static void narcissusNumber(int n){
        //求水仙花
        //判断位数
        int tmp=n;
        int count=0;
        while(tmp!=0){
            count++;
            tmp/=10;
        }
        //得到位数后，判断是不是水仙花数
        //153 =  3+50+100
        int sum=0;
        tmp=n;
        while(tmp!=0){
            sum+=Math.pow(tmp%10,count);
            tmp/=10;
        }
        if(sum==n){
            System.out.println(sum);
        }
    }

    public static void xPattern(){
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                //i==j为左对角线，i+j=row-1为右对角线
                if(i==j||i+j==row-1){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void newYear(){
        for(int i=1000;i<=2000;i++){
            if(i%4==0&&i%100!=0 || i%400==0){
                System.out.println(i);
            }
        }
    }

    /**
     * 判断一个数是否为素数
     * @param n
     * @return
     */
    public static boolean primeNumber(int n){
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    /**
     * 打印1-100之间的素数
     *
     */

    public static void printPrimeNum(){
        for(int i=1;i<=100;i++){
            if(primeNumber(i)){
                System.out.println(i);
            }
        }
    }

    /**
     * 编写程序数一下 1到 100 的所有整数中出现多少个数字9
     * @return
     */
    public static int nineCount()
    {
        int count=0;
        for(int i=1;i<=100;i++){
            if(i%10==9||i/10%10==9){
                count++;
            }
        }
        return count;
    }

    public static int greatestCommonDivisor() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b= scanner.nextInt();
        int c=b;
        while(a%b!=0){
            c=a%b;
            a=b;
            b=c;
        }
        return b;
    }

    public static void main(String[] args) {
        //multiply();
        //login();
        //allNarcissusNumber();
        //xPattern();
        //newYear();
        //System.out.println(primeNumber(11));
        //printPrimeNum();
        //System.out.println(nineCount());
        System.out.println(greatestCommonDivisor());
    }
}
