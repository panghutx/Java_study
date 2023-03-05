import bao.Demo1;

/**
 * 测试protected的访问权限
 */
public class Demo13 extends Demo1 {
    public static void main(String[] args) {
        Demo13 demo = new Demo13();
        System.out.println(demo.c);
    }
}
