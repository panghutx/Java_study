public class MythreadDemo {
    //继承Thread类
    static class Mythread extends Thread {
        @Override
        public void run() {
            System.out.println("我是一个线程");

        }

    }

    public static void main(String[] args) {
        Mythread t = new Mythread();
        t.start();


    }
}
