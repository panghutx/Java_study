package file;

import java.io.*;

public class New1 {
    //一次读取一个字节
    private static void readOne(File file,FileInputStream fileInputStream) throws IOException {
        try {
            fileInputStream = new FileInputStream(file);
            while(true){
                int read = fileInputStream.read();
                if(read==-1){
                    break;
                }
                System.out.print((char)read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }
    }

    //一次读取多个字节
    private static void readByte(File file,FileInputStream inputStream){
        try {
            inputStream = new FileInputStream(file);
            while(true){
                byte[] bytes = new byte[1024];
                int read = inputStream.read(bytes);
                if(read==-1){
                    break;
                }
                for (int i = 0; i < read; i++) {
                    System.out.print((char)bytes[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //一次写入一个字节
    private static void writeOne(File file, FileOutputStream outputStream) throws IOException {
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(103);
            outputStream.write(104);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            outputStream.close();
        }
    }
    //一次写入多个字节
    private static void writeByte(File file,FileOutputStream outputStream) throws IOException {
        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[]{'p','a','n','g','h','u'};
            outputStream.write(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            outputStream.close();
        }
    }

    //一次读取一个字符
    private static void readOne(File file,Reader reader) throws IOException {
        try {
            reader = new FileReader(file);
            while(true){
                int read = reader.read();
                if(read==-1){
                    break;
                }
                System.out.print((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            reader.close();
        }
    }
    //一次读取多个字符
    private static void readCharacter(File file,Reader reader) throws IOException {
        try {
            reader = new FileReader(file);
            char[] buffer = new char[1024];
            while(true){
                int read = reader.read(buffer);
                if (read==-1){
                    break;
                }
                String s = new String(buffer,0,read);
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            reader.close();
        }
    }
    //一次写入一个字符
    private static void writeOne(File file,Writer writer) throws IOException {
        try {
            writer = new FileWriter(file);
            writer.write("我是panghutx");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("./test.txt");
        FileInputStream fileInputStream = null;
        FileOutputStream outputStream = null;
        Reader reader=null;
        Writer writer = null;
        if(!file.exists()){
            file.createNewFile();
        }
        //readOne(file,fileInputStream);
        //readByte(file,fileInputStream);
        //writeOne(file,outputStream);
        //writeByte(file,outputStream);
        //readOne(file,reader);
        //readCharacter(file,reader);
        writeOne(file,writer);
    }


}
