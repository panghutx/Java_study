public class ThreadDemo1 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for(int i=0;i<10;i++){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"MyThread");
        //Thread几个常见的属性
        t.start();
        System.out.println(t.getName());
        System.out.println(t.getState());
        System.out.println(t.isInterrupted());
        //判断内核中的PCB是否存在
        System.out.println(t.isAlive());
    }
}
