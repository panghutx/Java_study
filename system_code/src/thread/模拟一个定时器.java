package thread;

import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;

public class 模拟一个定时器 {
    static class MyTask implements Comparable<MyTask>{

        //描述
        public Runnable runnable=null;
        public long time;

        public MyTask(Runnable runnable, long delay) {
            this.runnable = runnable;
            this.time = System.currentTimeMillis()+delay;
        }
        public void run(){
            runnable.run();
        }

        @Override
        public int compareTo(MyTask o) {
            return (int) (this.time-o.time);
        }
    }
    //组织
    static class MyTimer{
        private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();
        private Object locker = new Object();
        public void schedule(Runnable runnable,long delay){
            MyTask myTask = new MyTask(runnable, delay);
            queue.put(myTask);
            synchronized (locker){
                locker.notify();
            }
        }

        public MyTimer() {
            Thread t1 = new Thread(()->{
                while(true){
                    try {
                        MyTask take = queue.take();
                        if(take.time>System.currentTimeMillis()){
                            //没到时间
                            synchronized (locker){
                                locker.wait(take.time-System.currentTimeMillis());
                            }
                            queue.put(take);
                        }else{
                            take.run();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.start();
        }
    }

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        },3000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hhh");
            }
        },1000);

    }
}
