import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 * Description: 写操作
 * public abstract class OutputStream
 * extends Object
 * implements Closeable, Flushable
 * 这个抽象类是表示字节输出流的所有类的超类。 输出流接收输出字节并将其发送到某个接收器。
 * 需要定义OutputStream子类的应用OutputStream必须至少提供一个写入一个字节输出的方法。
 * User: panghu
 * Date: 2022-04-19
 * Time: 12:21
 */
public class TestDemo6 {
    public static void main(String[] args) {
        try(OutputStream outputStream = new FileOutputStream("text.txt")){
/*            byte[] buffer = new byte[] {'a','b','c','d'};
            int len=buffer.length;
            outputStream.write(buffer,0,len);*/

            //传入字符串，将字符串转入byte树
            String str = new String("胖虎同学");
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
