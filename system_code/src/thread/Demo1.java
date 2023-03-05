package thread;

/**
 * 创建一个饿汉模式
 */
class Singleton{
    //1.使用static创建一个实例，并且立即实例化
    private static Singleton instance = new Singleton();
    //2.为了防止在其他地方不小心new这个Singleton，把方法构造为private
    private Singleton(){}
    //3.提供一个方法，让外面能够拿到唯一实例
    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 创建一个懒汉模式
 */
class Singleton1{
    //1.不立即初始化实例，使用时再初始化
    private static volatile Singleton1 instance = null;
    //2.将构造方法设为private
    private Singleton1(){}
    //3.提供方法获取实例
    public static Singleton1 getInstance() {
        if(instance==null){
            synchronized (Singleton1.class){
                if(instance==null){
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        //Singleton singleton = new Singleton();
    }
}
