public class MyThread3{
    //匿名内部类来创建Thread子类
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("thread");
            }
        };
        t.start();
        System.out.println("main");
    }
}
