import java.util.*
;public class Hello {
    public static void main(String[] args) {
       /*  1.switch练习
        Scanner scan = new Scanner(System.in);
        switch(scan.nextInt()) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            default:
                System.out.println("都不是");
                break;
             */
        // 2.打印1-10的数字
       /*  int i=1;
        while(i<=10) {
            System.out.print(i);
            i++;
        } */
        // 3.计算1-100的和
      /*   int num=1;
        int sum=0;
        for(num=1;num<=100;num++) {
            sum += num;
        }
        System.out.println(sum);
        } */
        // 4.计算5的阶乘
      /*   int i=1;
        int rst=1;
        for(i=1;i<=5;i++) {
            rst *= i;
        }
        System.out.println(rst); */
        // 5.计算1的阶乘到5的阶乘之和
/*         int sum=0;
        for(int j=1;j<=5;j++) {
            int i=1;
            int rst=1;
            for(i=1;i<=j;i++) {
                rst *= i;
            }
            sum += rst;
        }
        System.out.println(sum); */
        // 6.使用 Scanner 读取字符串/整数/浮点数
/*         Scanner scan = new Scanner(System.in);
        System.out.println("请输入姓名:");
        String name = scan.nextLine();
        System.out.println("请输入年龄:");
        int age = scan.nextInt();
        System.out.println("请输入工资:");
        float salary = scan.nextFloat();
        System.out.printf("姓名：%s，年龄：%d，工资：%f",name,age,salary); */
        // 7.根据年龄，来打印出当前年龄的人是少年，青年，中年，老年
/*         Scanner scan = new Scanner(System.in);
        int age=scan.nextInt();
        if(age<18) {
            System.out.println("少年");
        } else if(age>18&&age<28) {
            System.out.println("青年");
        } else if(age>28&&age<55) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        } */
        // 8.判断一个数是不是素数
        /* Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        for(int i=2;i<n;i++){
            if(n%i==0){
                System.out.println(n+"不是素数");
                break;
            }
        } */
        //9.打印1-100以内的素数
/*         for(int j=2;j<=100;j++){
            int i=2;
            for(i=2;i<j;i++){
                if(j%i==0){
                    // System.out.println(j+"不是素数");
                    break;
                }
                
            } 
            if(i>=j){
                System.out.println(j+"是素数");
            }
            
        } */
        
    }
}
