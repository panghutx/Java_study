package file;

//文件读取操作练习
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo5 {
    public static void main1(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("d://hello.txt");
        try {
            while(true){
                int n = fileInputStream.read();
                if(n==-1){
                    break;
                }
                System.out.println(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //测试try with resources 隐式调用close
    public static void main2(String[] args) {
        try(FileInputStream file = new FileInputStream("d://hello.txt")) {
            while(true){
                int n=file.read();
                if(n==-1){
                    break;
                }
                System.out.println(n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //测试一次读取多个字节
    public static void main(String[] args) {
        try(FileInputStream file = new FileInputStream("d://hello.txt")) {
            while(true){
                byte[] bytes = new byte[1024];
                int read = file.read(bytes);
                if(read==-1){
                    break;
                }

                for (int i = 0; i < read; i++) {
                    System.out.println(bytes[i]);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}
