package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//实现文件拷贝操作
public class Demo11 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入原路径");
        String origin = scanner.nextLine();
        System.out.println("请输入目标路径");
        String dest = scanner.nextLine();
        File file = new File(origin);
        if(!file.isFile()){
            System.out.println("原路径错误");
            return;
        }
        try(FileInputStream fileInputStream = new FileInputStream(origin)){
            try(FileOutputStream outputStream = new FileOutputStream(dest)){
                byte[] buffer = new byte[1024];
                while(true){
                    int len = fileInputStream.read(buffer);
                    if(len==-1){
                        break;
                    }
                    outputStream.write(buffer,0,len);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
