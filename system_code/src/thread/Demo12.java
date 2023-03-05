package thread;
class MyblockQueue{
    private int[] elem = new int[100];
    private int head;
    private int end;
    private int size;
    private Object locker = new Object();


    public void put(int data) throws InterruptedException {
        synchronized (locker) {
            if (size == elem.length) {
                //满了，阻塞等待
                locker.wait();
            }

            elem[end++] = data;
            locker.notify();
            if (end >= elem.length) {
                end = 0;
            }
            size++;
        }
    }
    public int take() throws InterruptedException {
        synchronized (locker){

            if(size==0){
                //空了，阻塞等待
                locker.wait();
            }
            int val = elem[head];
            head++;
            locker.notify();
            if(head>=elem.length){
                head=0;
            }
            size--;
            return val;
        }

    }
}
public class Demo12 {
    public static void main(String[] args) {
        MyblockQueue queue = new MyblockQueue();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    queue.put(i);
                    System.out.println("生产了："+i);
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    int val=queue.take();
                    System.out.println("消费了："+val);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();


    }
}
