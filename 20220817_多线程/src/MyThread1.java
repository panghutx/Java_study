/**
 * 创建线程
 * 方法1：继承Thread类，重写run方法
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("myThread");
        }

    }

    public static void main(String[] args) {
        Thread t = new MyThread1();
        t.start();
        while(true){
            System.out.println("Main");
        }

    }
}
