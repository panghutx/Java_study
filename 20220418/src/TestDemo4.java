import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description: 字节流读取操作 缓冲区
 * User: panghu
 * Date: 2022-04-19
 * Time: 11:57
 */
public class TestDemo4 {
    public static void main(String[] args) throws IOException {

        try(InputStream inputStream = new FileInputStream("text.txt")){
            while(true){
                //buffer相当于一个缓冲区，将txt文件读到的字节存到buffer
                byte[] buffer = new byte[1024];
                int len=inputStream.read(buffer);
                if(len==-1){
                    break;
                }
                String str = new String(buffer,0,len,"UTF-8");
                System.out.println(str);
            }


        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
