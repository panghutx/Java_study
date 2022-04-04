public class MythreadDemo2 {

    static class MyThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("线程正在运行中");
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyThread2());
        t.start();



    }
}
