package thread;

//定时器案例练习

import java.util.concurrent.PriorityBlockingQueue;

//描述一个任务
class MyTask1 implements Comparable<MyTask1>{
    private Runnable runnable;
    private long time;

    public MyTask1(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis()+delay;
    }

    public void run(){
        runnable.run();
    }

    public long getTime(){
        return time;
    }

    @Override
    public int compareTo(MyTask1 o) {
        return (int) (this.time-o.time);
    }
}
//组织一个任务
class MyTimer1{
    private PriorityBlockingQueue<MyTask1> queue = new PriorityBlockingQueue<>();
    private Object locker = new Object();

    public void schedule(Runnable runnable,long delay) {
        MyTask1 myTask1 = new MyTask1(runnable, delay);
        queue.put(myTask1);
        //放入新任务后解锁，刷新扫描器
        synchronized (locker){
            locker.notify();
        }
    }

    //执行到时间的任务
    public MyTimer1(){
        Thread t1 = new Thread(()->{
            while(true){
                MyTask1 myTask1 = null;
                try {
                    myTask1 = queue.take();
                    if(System.currentTimeMillis()<myTask1.getTime()){
                        queue.put(myTask1);
                        //避免忙等问题，加锁，到时间后解锁
                        synchronized (locker){
                            locker.wait(myTask1.getTime()-System.currentTimeMillis());
                        }
                    }else{
                        myTask1.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
    }
}
public class Demo13 {
    public static void main(String[] args) {
        MyTimer1 myTimer1 = new MyTimer1();
        myTimer1.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        },1000);

        MyTimer1 myTimer2 = new MyTimer1();
        myTimer1.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello2");
            }
        },500);
    }
}
