package file;

import java.io.*;

/**
 * 写文件操作
 */
public class Demo6 {
    //一个字节一个字节地来写
    public static void main1(String[] args) {
        try(FileOutputStream file = new FileOutputStream("d://hello.txt",true)) {
            file.write(103);
            file.write(104);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //成批的写
    public static void main(String[] args) {
        try(FileOutputStream file = new FileOutputStream("d://hello.txt")) {
            byte[] buffer = new byte[1024];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i]=97;
            }
            file.write(buffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}
