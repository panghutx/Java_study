/**
 * 新建类，实现Runnable接口
 * 实例化对象，将其作为Thread参数
 */

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("myRunnable");
    }
}
public class MyThread2{

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);
        t.start();
        System.out.println("main");
    }
}
