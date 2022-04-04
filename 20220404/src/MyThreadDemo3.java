public class MyThreadDemo3 {
    //匿名内部类
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println(123);
            }
        };

        t.start();
    }
}
