public class TestDemo2 {
    public static void main1(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("0");
        });
        Thread t2 = new Thread(()->{
            System.out.println("1");
        });
        Thread t3 = new Thread(()->{
            System.out.println("2");
        });
        Thread t4 = new Thread(()->{
            System.out.println("3");
        });
        Thread t5 = new Thread(()->{
            System.out.println("4");
        });
        Thread t6 = new Thread(()->{
            System.out.println("5");
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ok");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        //创建20个线程
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            threads[i]=new Thread(()->{
                System.out.println(finalI);
            });
        }
        //启动线程
        for (int i = 0; i < 20; i++) {
            threads[i].start();
        }
        //阻断线程
        for (int i = 0; i < 20; i++) {
            threads[i].join();
        }
        System.out.println("ok");

    }
}
