package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的使用
 * 使用ThreadPoolExecutor创建一个忽略最新任务的线程池，创建规则：
 * 1.核心线程数为5
 * 2.最大线程数为10
 * 3.任务队列为100
 * 4.拒绝策略为忽略最新任务
 */
public class Demo15 {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>(100);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,10,3, TimeUnit.SECONDS,queue,new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "已执行.");
            },"thread-" + (i + 1)).start();
        }
    }
    
}
