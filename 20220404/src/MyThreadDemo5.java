public class MyThreadDemo5 {
    public static void main(String[] args) {
        Thread t = new Thread(()-> {
            System.out.println(123);

        });

        t.start();
    }
}
