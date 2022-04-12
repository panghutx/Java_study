import java.util.Arrays;

public class TestDemo {
    //某数二进制奇偶互换
    public static int[] Reverse(int n){
        int arr[] = new int[32];
        for(int i=0;i<32;i=i+2){
            arr[i+1]=(n>>>i)&1;
        }
        for(int i=1;i<32;i=i+2){
            arr[i-1]=(n>>>i)&1;
        }
        return arr;
    }
    //更妙的做法
    public static int Reverse1(int n){
        return ((n&(0x55555555))<<1) + ((n&(0xaaaaaaaa))>>1);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Reverse(2)));
        System.out.println(Reverse1(10));
    }
}
