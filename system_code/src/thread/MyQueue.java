package thread;

public class MyQueue {
    public int[] elem = new int[10];
    public int head;
    public int tail;
    public int size;
    public final Object locker = new Object();

    public void put(int val) throws InterruptedException {
        synchronized (locker){
            //队列满了，阻塞等待
            if(size==elem.length){
                locker.wait();
            }
            //一轮循环，让尾指针指向数组下标为0的位置
            if(tail==elem.length){
                tail=0;
            }
            elem[tail++]=val;
            size++;
            //唤醒消费者线程的堵塞等待
            locker.notify();
        }

    }
    public int take() throws InterruptedException {
        synchronized (locker){
            //队列空了，阻塞等待
            if(size==0){
                locker.wait();
            }
            if(head==elem.length){
                head=0;
            }
            int ret = elem[head];
            head++;
            size--;
            //唤醒生产者线程的堵塞等待
            locker.notify();
            return ret;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyQueue queue = new MyQueue();
        //生产者
        Thread t1 = new Thread(()->{
            int i=0;
            while (true){
                try {
                    queue.put(i);
                    System.out.println("生产了："+i);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //消费者
        Thread t2 = new Thread(()->{
            while(true){
                try {
                    int take = queue.take();
                    System.out.println("消费了："+take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }
}
