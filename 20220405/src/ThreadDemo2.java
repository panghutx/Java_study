public class ThreadDemo2 {
    static boolean flat = true;
    static class MyThread extends Thread {

        @Override
        public void run() {
            while(flat){

                try {
                    System.out.println("线程运行中");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {

        Thread t = new MyThread();
        t.start();
        Thread.sleep(4000);
        //线程中断：自定义标识符
        flat=false;

    }
}
