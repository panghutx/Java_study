package file;

import java.io.*;
import java.util.Scanner;

/**
 * 案例1：在指定目录下查找具有关键字的文件
 */
public class Demo9 {
    public static void main(String[] args) throws IOException {
        //1.输入要扫描的路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径:");
        String path = scanner.nextLine();
        System.out.println("请输入关键字:");
        String name = scanner.nextLine();
        File file = new File(path);

        if(!file.isDirectory()){
            System.out.println("文件名非法");
            return;
        }
        //2.递归遍历
        scan(file,name);
    }
    public static void scan(File file,String name) throws IOException {
        //列出目录下的所有文件
        File[] files = file.listFiles();
        if(files==null){
            return;
        }
        for (File fil:files) {
            if(!fil.isDirectory()){
                if(containsWord(fil,name)){
                    System.out.println(fil.getCanonicalPath());
                }
            }else{
                scan(fil,name);
            }
        }
    }

    private static boolean containsWord(File fil, String name) {
        StringBuilder stringBuilder = new StringBuilder();
        try(Reader reader = new FileReader(fil)){

            char[] buffer = new char[1024];
            while(true){
                int len = reader.read(buffer);
                if(len==-1){
                    break;
                }
                stringBuilder.append(buffer,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.indexOf(name)!=-1;
    }
}
