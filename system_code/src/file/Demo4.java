package file;

import java.io.File;
import java.io.IOException;

// 文件重命名
public class Demo4 {
    public static void main(String[] args) throws IOException {
        File f = new File("./aaa");
        f.createNewFile();
        File f2 = new File("./zzz");
        System.out.println(f.renameTo(f2));
    }
}
