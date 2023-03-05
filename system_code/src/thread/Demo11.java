package thread;

/**
 * 创建一个饿汉模式
 * 每次初始化时都创建一个实例
 */
class Singleton3{
    private static Singleton3 instance = new Singleton3();

    //防止在其他类中创建实例
    private Singleton3() {}

    public static Singleton3 getInstance() {
        return instance;
    }
}

/**
 * 创建一个懒汉模式
 */
class Singleton4{
    private static volatile Singleton4 instance=null;
    private Singleton4(){}
    public static Singleton4 getInstance(){
        if(instance==null){
            synchronized (Singleton4.class){
                if(instance==null){
                    instance=new Singleton4();
                }
            }
        }
        return instance;
    }

}
public class Demo11 {
    public static void main(String[] args) {

    }
}
