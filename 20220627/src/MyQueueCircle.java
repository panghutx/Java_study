import java.util.Queue;
import java.util.Stack;

public class MyQueueCircle {
    public int[] elem;
    public int usedSize;
    public int head;
    public int tail;

    public MyQueueCircle(int k) {
        elem = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elem[tail] = value;
        tail = (tail + 1) % elem.length;
        usedSize++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % elem.length;
        usedSize--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return elem[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        int index = tail == 0 ? elem.length - 1 : tail - 1;
        return elem[index];
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    public static void main(String[] args) {
        MyQueueCircle circularQueue = new MyQueueCircle(3);
        System.out.println(circularQueue.enQueue(1));// 返回 true
        System.out.println(circularQueue.enQueue(2)); // 返回 true
        System.out.println(circularQueue.enQueue(3)); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 false，队列已满
        System.out.println(circularQueue.Rear()); // 返回 3
        System.out.println(circularQueue.isFull()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 true
        System.out.println(circularQueue.Rear()); // 返回 4

    }
}