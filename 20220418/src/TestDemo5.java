import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 阅读字符文件的便利课。 该类的构造函数假定默认字符编码和默认字节缓冲区大小是适当的。 要自己指定这些值，请在FileInputStream上构造一个InputStreamReader。
 * FileReader是用于读取字符流。 要读取原始字节流，请考虑使用FileInputStream 。
 * User: panghu
 * Date: 2022-04-19
 * Time: 12:15
 */
public class TestDemo5 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("text.txt")){
            while(true){
                int b = reader.read();
                if(b==-1){
                    break;
                }
                System.out.print((char)b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
