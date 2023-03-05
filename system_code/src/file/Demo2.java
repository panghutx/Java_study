package file;

import java.io.File;

/**
 * mkdir 创建目录
 * mkdirs 创建多级目录
 */
public class Demo2 {
    static File f = new File("./aaa/bbb/ccc/ddd");

    public static void main(String[] args) {
        File ff = new File("hhh");
        System.out.println(ff.mkdir());
        System.out.println(f.mkdirs());
    }
}
