package thread;

/**
 * 请完成以下多线程编程：顺序打印
 *
 * 有三个线程，线程名称分别为：a，b，c。
 * 每个线程打印自己的名称。
 * 需要让他们同时启动，并按 c，b，a的顺序打印
 */
public class Demo9 {

    static Thread t1 = new Thread(()->{
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a"+Thread.currentThread());
    });

    static Thread t2 = new Thread(()->{
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b"+Thread.currentThread());

    });

    static Thread t3 = new Thread(()->{
        System.out.println("c"+Thread.currentThread());

    });

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
        t3.start();
    }
}
