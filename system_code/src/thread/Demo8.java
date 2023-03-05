package thread;

/**
 * 使用两个线程来累加 count 的值
 * 每个线程循环 1w 次，累加变量 count 的值，count 默认值为 0，注意线程安全问题。
 */
public class Demo8 {
    private static int count=0;
    private static Object locker = new Object();
    static Thread t1 = new Thread(()->{
        synchronized (locker){
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
    });

    static Thread t2 = new Thread(()->{
        synchronized (locker){
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

}
