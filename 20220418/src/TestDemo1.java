import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: IO操作
 * User: panghu
 * Date: 2022-04-18
 * Time: 22:32
 */
public class TestDemo1 {
    public static void main(String[] args) throws IOException {
        File f = new File("d:\\test.txt");
        //f.createNewFile(); //当文件名不存在时，创建一个新文件
        System.out.println(f.exists()); //判断文件是否存在
        System.out.println(f.getParent());
        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());

        System.out.println("=================");

/*        File f2 = new File("./test.txt");
        System.out.println(f2.getParent());
        System.out.println(f2.getName());
        System.out.println(f2.getPath());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getCanonicalPath());*/

/*        File f2 = new File("./panghutx/text/css");
        //f2.mkdir(); //创建一个目录
        boolean ret = f2.mkdirs(); //创建多级目录
        System.out.println(ret);
        File f3 = new File("./panghutx/text/css/text.md");
        boolean newFile = f3.createNewFile();//创建文件
        System.out.println(newFile);*/

    }
}
