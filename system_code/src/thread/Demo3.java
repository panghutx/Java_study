package thread;

/**
 * 模拟实现一个阻塞队列
 * 生产者消费者模型
 */
class MyBlockingQueue{
    private int[] elem = new int[1000];
    private int size=0;
    private int head=0;
    private int tail=0;
    private final Object locker = new Object(); //专门的锁对象

    /**
     * 入队列操作
     * @param val
     */
    public void put(int val) throws InterruptedException {
        synchronized(locker){
            if(size==elem.length){
                //return;
                //阻塞操作
                locker.wait();
            }
            elem[tail]=val;
            tail++;
            // tail = tail%elem.length;
            if(tail>=elem.length){
                tail=0;
            }
            size++;
            locker.notify();
        }

    }

    public int take() throws InterruptedException {
        synchronized (locker){
            if(size==0){
                //return 0;
                //队列为空，阻塞
                locker.wait();
            }

            int ret=elem[head];
            head++;
            if(head>=elem.length){
                head=0;
            }
            size--;
            locker.notify();
            return ret;
        }

    }

}
public class Demo3 {
    private static MyBlockingQueue queue = new MyBlockingQueue();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int num=0;
            while(true){
                try {
                    System.out.println("生产了："+num);
                    queue.put(num);
                    num++;
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            while(true){
                try {
                    int ret = queue.take();
                    System.out.println("消费了:"+ret);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }
}
