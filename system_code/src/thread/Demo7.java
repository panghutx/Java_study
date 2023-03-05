package thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 模拟实现一个线程池
 */
class MyThreadPool{
    //1.描述任务，直接用Runnable即可
    //2.组织任务，用到阻塞队列
    private BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
    //3.描述线程,从队列中取任务，执行
    static class Worker extends Thread{
        private BlockingDeque<Runnable> queue = null;

        public Worker(BlockingDeque<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
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
    //4.组织线程
    List<Worker> workers = new LinkedList<>();
    public MyThreadPool(int n){
        //创建若干个线程，加入到线程池中
        for (int i = 0; i < n; i++) {
            Worker worker = new Worker(queue);
            worker.start();
            workers.add(worker);
        }
    }
    //5.将任务加入到线程
    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }

}
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(10);

        for (int i = 0; i < 100; i++) {
            int taskId = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务："+taskId+Thread.currentThread().getName());
                }
            });
        }

    }
}
