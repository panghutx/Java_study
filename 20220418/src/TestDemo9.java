import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 文件拷贝操作
 * User: panghu
 * Date: 2022-04-19
 * Time: 14:17
 */
public class TestDemo9 {
    public static void main(String[] args) {
        System.out.println("请输入要拷贝的源文件");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.next();
        System.out.println("请输入要拷贝的目标文件");
        String desc = scanner.next();
        File srcFile = new File(src);
        if(!srcFile.isFile()){
            System.out.println("源文件错误");
            return;
        }
        //进行复制，打开src，读取src中的内容写入到desc
        try(InputStream inputStream = new FileInputStream(src)){
            try(OutputStream outputStream = new FileOutputStream(desc)) {
                byte[] buffer = new byte[1024];
                while(true){
                    int b = inputStream.read(buffer);
                    if(b==-1) {
                        break;
                    }
                }
                outputStream.write(buffer);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        }
    }

