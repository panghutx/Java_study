import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description: 写操作 FilterWriter
 * User: panghu
 * Date: 2022-04-19
 * Time: 13:25
 */
public class TestDemo7 {

    public static void main(String[] args) {
        try(FileWriter printWriter = new FileWriter("./test.txt")){
            printWriter.write("我是胖虎同学");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
