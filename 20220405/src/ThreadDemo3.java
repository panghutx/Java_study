public class ThreadDemo3 {

    public static void main(String[] args) throws InterruptedException {
        //线程中断：使用isInterrupted()来获取标识符状态,使用interrupt()修改状态
        Thread t = new Thread(){
            @Override
            public void run() {
                //默认是false
                //Thread.currentThread().isInterrupted() 相当于按下开关之后, 开关弹不起来, 这个称为
                //"不清除标志位"
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("线程运行中");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        t.start();
        Thread.sleep(3000);
        //要看线程状态，线程运行时修改，线程阻塞时，抛出异常。
        t.interrupt();
    }
}
