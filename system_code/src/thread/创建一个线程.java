package thread;

public class 创建一个线程 {


    public static void main1(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个线程t1");
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println("我是线程t2");
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("我是main线程");
    }

    static volatile boolean flag = false;
    public static void main2(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while(!flag){
                    System.out.println("线程正在运行");
                }
            }
        };
        t.start();
        Thread.sleep(1000); //使线程进入休眠状态
        flag = true;
    }


        public static void main3(String[] args) throws InterruptedException {
            Thread t = new Thread(){
                @Override
                public void run() {
                    while(!Thread.currentThread().isInterrupted()){
                        System.out.println("线程运行中");
                    }
                }
            };
            t.start();
            Thread.sleep(1000);
            t.interrupt();
        }

    public static void main4(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 1000_0000; i++) {
            }
        }, "李四");
        System.out.println(t.getName() + ": " + t.getState());;
        t.start();
        while (t.isAlive()) {
            System.out.println(t.getName() + ": " + t.getState());;
        }
        System.out.println(t.getName() + ": " + t.getState());;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    System.out.println("张三");
// 先注释掉, 再放开
 Thread.yield();
                }
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("李四");
                }
            }
        }, "t2");
        t2.start();
    }

}
