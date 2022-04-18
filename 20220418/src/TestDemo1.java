import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: IO操作
 * User: panghu
 * Date: 2022-04-18
 * Time: 22:32
 */
public class TestDemo1 {
    public static void main(String[] args) throws IOException {
        File f = new File("d:\\test.txt");
        System.out.println(f.getParent());
        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());

        System.out.println("=================");

        File f2 = new File("./test.txt");
        System.out.println(f2.getParent());
        System.out.println(f2.getName());
        System.out.println(f2.getPath());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getCanonicalPath());
    }
}
