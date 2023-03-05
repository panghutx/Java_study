package file;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("hello.txt");
        System.out.println(file.exists());
        System.out.println(file.createNewFile());
        System.out.println(file.exists());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalPath());
//        System.out.println(file.getName());
//        System.out.println(file.getParent());
//        System.out.println(file.getCanonicalFile()); //得到文件的
//        System.out.println(file.getPath()); //得到文件路径（构造时指定的路径）
//        file.delete();
//        System.out.println(file.exists());
    }
}
