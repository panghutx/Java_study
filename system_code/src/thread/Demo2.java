package thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 阻塞队列标准库
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        //queue.put("hello");
        String s = queue.take();
        System.out.println(s);
    }
}
