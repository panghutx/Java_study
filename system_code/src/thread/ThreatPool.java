package thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreatPool {
    //描述一个任务
    //组织一个任务
    BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
    //描述一个线程
    //线程是用来执行任务的，而任务都存放在队列中
    static class Worker extends Thread{
        //通过构造方法能够拿到外面的queue
        private BlockingDeque<Runnable> queue = null;
        public Worker(BlockingDeque<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            //从queue中取任务，然后执行任务
            while(true){
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //组织线程,创建线程
    List<Worker> workers = new LinkedList<>();
    public ThreatPool(int n) {
        for (int i = 0; i < n; i++) {
            //创建线程，存放到线程池,执行线程
            Worker worker = new Worker(queue);
            workers.add(worker);
            worker.start();
        }
    }
    //提交任务到线程
    public void sumbit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreatPool pool = new ThreatPool(10);//线程数10
        //执行1000个任务
        for (int i = 0; i < 1000; i++) {
            int workId = i;
            pool.sumbit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务:"+workId+Thread.currentThread().getName());
                }
            });
        }
    }
}
