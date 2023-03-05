package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

//线程池练习案例
class ThreadPool1{
    //1.描述一个任务，用Runnable即可
    //2.组织任务，用阻塞队列
    BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
    //3.描述一个线程
    static class Mythread extends Thread{
        BlockingQueue<Runnable> queue = null;
        public Mythread(BlockingQueue<Runnable> queue){
            this.queue=queue;
        }
        //线程的工作就是从队列中取任务，执行任务
        public void run(){
            while(true){
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                    //将任务加入到线程

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //4.组织一个线程
    List<Mythread> works = new ArrayList<>();
    public ThreadPool1(int n){
        //6.创建n个线程，加入到线程池中
        for (int i = 0; i < n; i++) {
            Mythread work = new Mythread(queue);
            work.start();
            works.add(work);
        }

    }
    //5.将任务加入到线程
    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
}
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool1 pool1 = new ThreadPool1(10);
        pool1.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
    }
}
