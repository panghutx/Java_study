import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description: 字节流读取
 * User: panghu
 * Date: 2022-04-19
 * Time: 11:38
 */
public class TestDemo3 {

    public static void main(String[] args) throws IOException {
        //字节流读取操作
        InputStream inputStream = null;
        inputStream = new FileInputStream("./hhh.md");
        //一个字节一个字节地把数据读出来
        try{
            while(true){
                int b = inputStream.read();
                if(b==-1){
                    break;
                }
                System.out.println(b);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            //关闭文件
            inputStream.close();
        }

        try(InputStream inputStream1 = new FileInputStream("./text.txt")){
            while(true){
                int b = inputStream1.read();
                if(b==-1){
                    break;
                }
                System.out.printf("%c",b);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}