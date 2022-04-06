public class ThreadDemo2 {
    //自定义变量flag作为标志位
    static volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(){
            @Override
            public void run() {
                while(!flag){
                    System.out.println("线程正在运行");
                }
            }
        };
        t.start();
        Thread.sleep(1000);
        flag = true;
    }
}
