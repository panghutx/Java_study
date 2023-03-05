public class MyThread4 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread");
            }
        });
        t.start();
        System.out.println("main");
    }
}
