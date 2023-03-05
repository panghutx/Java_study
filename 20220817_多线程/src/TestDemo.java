import java.util.Arrays;
import java.util.Random;

public class TestDemo {
    static int ret1=0;
    static int ret2=0;
    public static void main(String[] args) {
        int len = 1_000_000;
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]= random.nextInt(100)+1;
        }
        concurrency(arr);


    }

    public static void concurrency(int[] arr){
        long begin = System.currentTimeMillis();

        Thread t1 = new Thread(()->{
            //计算偶数下标的和
            for (int i = 0; i < arr.length; i+=2) {
                ret1+=arr[i];
            }
        });
        Thread t2= new Thread(()->{
            for (int i = 1; i < arr.length ; i+=2) {
                ret2+=arr[i];
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("共耗时"+(end-begin)+"ms");
        System.out.println("求和结果为"+(ret1+ret2));
    }

    public static void serial(int[] arr){
        long begin = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i+=2) {
            ret1+=arr[i];
        }
        for (int i = 1; i < arr.length ; i+=2) {
            ret2+=arr[i];
        }
        long end = System.currentTimeMillis();
        System.out.println("共耗时"+(end-begin)+"ms");
    }
}
