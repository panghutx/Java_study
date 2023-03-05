package file;

//在指定目录下查找文件并删除

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Demo10 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径");
        String path = scanner.nextLine();
        System.out.println("请输入要删除的文件");
        String name = scanner.nextLine();

        File file = new File(path);
        if(!file.isDirectory()){
            System.out.println("目录非法");
            return;
        }
        fileScan(file,name);

    }

    private static void fileScan(File file, String name) throws IOException {
        //列出目录下的文件
        File[] files = file.listFiles();
        if(files==null){
            return;
        }
        for (File f:files) {
            if(f.isFile()){
                String fname = f.getName();
                if(fname.contains(name)){
                    System.out.println("找到要删除的文件"+f.getCanonicalPath()+"，是否删除(Y/N)");
                    Scanner scanner = new Scanner(System.in);
                    String ans = scanner.next();
                    if(ans.equals("Y")){
                        f.delete();
                        System.out.println("文件删除成功");
                    }else{
                        System.out.println("文件取消删除");
                        return;
                    }
                }
            }else{
                fileScan(f,name);
            }
        }
    }
}
