package thread;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 模拟实现一个定时器
 */

//描述一个任务
class MyTask implements Comparable<MyTask>{
    //具体要干啥
    private Runnable runnable;
    //啥时候开始干
    private long time;

    public MyTask(Runnable runnable,long dalay){
        this.runnable = runnable;
        this.time=System.currentTimeMillis()+dalay;
    }
    public void run(){
        runnable.run();
    }
    public long getTime(){
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        //背下来
        return (int) (this.time-o.time);
    }
}
//组织一个任务
class MyTimer{
    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();
    private Object locker = new Object();
    public void schedule(Runnable runnable,long delay){
        MyTask myTask = new MyTask(runnable,delay);
        queue.put(myTask);
        synchronized (locker){
            locker.notify();
        }
    }
    //执行到时间的任务
    public MyTimer(){
        Thread t1 = new Thread(()->{
            while(true){
                try {
                    //取队首元素
                    MyTask task = queue.take();
                    long time=System.currentTimeMillis();
                    if(time<task.getTime()){
                        //时间还没到
                        queue.put(task);
                        synchronized (locker){
                            locker.wait(task.getTime()-time);
                        }
                    }else{
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        });
        t1.start();
    }

}
public class Demo5 {


    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        },3000);
        System.out.println("main");
    }
}
