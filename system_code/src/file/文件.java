package file;

import java.io.File;
import java.io.IOException;

public class 文件 {
    public static void main(String[] args) throws IOException {
        //创建一个hello的目录
        File dir = new File("hello");
        if(!dir.exists()){
            dir.mkdirs();
        }
        //在hello目录下创建一个hello.txt文件
        File file = new File(dir+"/hello.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        //得到文件名
        System.out.println(file.getName());
        //得到文件的绝对路径
        System.out.println(file.getAbsolutePath());
        //得到文件的规范路径，当路径不规范时，会进行优化(去掉.)
        System.out.println(file.getCanonicalPath());
        //得到父目录名
        System.out.println(file.getParent());
    }

    public static void main1(String[] args) throws IOException {

            // 传入目录相对路径
            File imagesDir = new File(".\\images");
            File imoocDir = new File("..\\imooc");

            // 传入文件相对路径
            File file = new File(".\\Hello.java");

            System.out.println("-- imagesDir ---");
            System.out.println(imagesDir.getPath());            //.\images
            System.out.println(imagesDir.getAbsolutePath());        //C:\mukew\Java_Tutorial\.\images
            System.out.println(imagesDir.getCanonicalPath());           //C:\mukew\Java_Tutorial\images

            System.out.println("-- imoocDir ---");
            System.out.println(imoocDir.getPath());             //..\imooc
            System.out.println(imoocDir.getAbsolutePath());         //C:\mukew\Java_Tutorial\..\imooc
            System.out.println(imoocDir.getCanonicalPath());            //C:\mukew\imooc

            System.out.println("-- file ---");
            System.out.println(file.getPath());                 //.\Hello.java
            System.out.println(file.getAbsolutePath());             //C:\mukew\Java_Tutorial\.\Hello.java
            System.out.println(file.getCanonicalPath());                //C:\mukew\Java_Tutorial\Hello.java
    }

}
