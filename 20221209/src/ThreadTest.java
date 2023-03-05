public class ThreadTest {
    /**
     * 两个线程交替打印ababab
     */
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(()->{
            while(true){
                synchronized (locker){
                    System.out.print("a");
                    locker.notify();
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(()->{
            while(true){
                synchronized (locker){
                    System.out.print("b");
                    locker.notify();
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

    }


}
