public class MyThread5 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("thread");
        });
        t.start();
        System.out.println("main");
    }
}
