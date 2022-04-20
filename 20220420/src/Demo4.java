/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: panghu
 * Date: 2022-04-20
 * Time: 20:50
 */
public class Demo4 {
    public int reverse1(int x) {
        int ret = 0;
        while (x != 0) {   //123
            if (ret < Integer.MIN_VALUE / 10 || ret > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;  //1
            x /= 10;  //0
            ret = ret * 10 + digit;   //321
        }
        return ret;
    }
    public static int reverse(int x) {
        //判断数字的位数
        int count=0;
        int tmp=x;
        while(tmp!=0){
            tmp/=10;
            count++;
        }
        //逆序x
        tmp=x;
        int sum=0;
        for(int i=0;i<count;i++){
            sum+= (tmp/ (int)Math.pow(10,count-1-i))%10 * (int)Math.pow(10,i);

        }
        return sum;

    }
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
