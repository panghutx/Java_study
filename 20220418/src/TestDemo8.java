import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 写一个代码, 根据指定的路径, 对路径进行遍历, 删除符合要求的文件.
 * 1.查找  找目标路径和目标文件
 * 2.保存  将匹配到的文件保存到result
 * 3.删除  删除result中的指定文件
 * User: panghu
 * Date: 2022-04-19
 * Time: 13:34
 */
public class TestDemo8 {
    public static void main(String[] args) throws IOException {
        //输入目标文件路径
        System.out.println("请输入要删除的文件路径");
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.next();
        //检查输入文件路径是否正确
        File dirName = new File(dir);
        if(!dirName.isDirectory()){
            System.out.println("目标路径不存在");
            return;
        }
        //目标路径存在，输入要删除的文件
        System.out.println("请输入要删除的文件名");
        String fileName = scanner.next();
        List<File> result = new ArrayList<>();
        scan(dirName,fileName,result);
        //删除result中的文件
        if(result.isEmpty()){
            System.out.println("无匹配项");
        }
        for(File file:result){
            System.out.println(file.getCanonicalPath() + " 该文件是否确认删除? Y/n");
            String choice = scanner.next();
            if (choice.equals("Y")) {
                file.delete();
                System.out.println(file.getCanonicalPath() + " 该文件删除成功!");
            }
        }

    }
    public static void scan(File dirName,String fileName,List result) throws IOException {
        //列出目录下的所有文件
        File[] files = dirName.listFiles();
        for(File file:files){
            System.out.println("扫描了文件: " + file.getCanonicalPath());
            //如果file是普通文件
            if(file.isFile()){
                //如果文件名与要删除的文件名匹配,将文件加入到结果列表
                if(file.getName().equals(fileName)){
                    result.add(file);
                }
            }else if(file.isDirectory()){
                //是目录，继续调用这个方法，直到找到目标文件
                scan(file,fileName,result);
            }
        }
    }
}
