package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 标准库中的定时器
 */
public class Demo4 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 3000);
    }

}
