public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
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
}
