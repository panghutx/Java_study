package thread;

import java.util.Timer;
import java.util.TimerTask;

public class 定时器 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("123");
            }
        },3000);
    }
}
