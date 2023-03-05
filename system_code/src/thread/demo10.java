package thread;

/**
 * 有三个线程，分别只能打印A，B和C
 * 要求按顺序打印ABC，打印10次
 * 输出示例：
 * ABC
 * ABC
 * ……
 */
public class demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread ta=new Thread(()->{
            System.out.print("A");
        });
        Thread tb=new Thread(()->{
            try {
                ta.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("B");
        });
        Thread tc=new Thread(()->{
            try {
                tb.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("C");
        });

        for (int i = 0; i < 10; i++) {
            ta.start();
            tb.start();
            tc.start();
            ta.join();
            tb.join();
            tc.join();
            System.out.println();
        }


    }
}
