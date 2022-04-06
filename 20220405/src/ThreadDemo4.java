public class ThreadDemo4 {

    //线程的状态
    //NEW
    //RUNNABLE 就绪状态
    //TIME_WAITING  sleep后，线程被堵塞，有时间限制
    //WAITING wait后，线程被堵塞，无时间限制
    //

    //使用 isAlive 方法判定线程的存活状态
        public static void main(String[] args) throws InterruptedException {
            Thread t = new Thread(() -> {
                for (int i = 0; i < 1000_0000; i++) {
                }
            }, "李四");
            System.out.println(t.getName() + ": " + t.getState());;
            t.start();
            while (t.isAlive()) {
                System.out.println(t.getName() + ": " + t.getState());;
            }
            System.out.println(t.getName() + ": " + t.getState());;
        }


}