package file;

import java.io.*;

public class Demo12 {
    private static String name = "D:\\bit\\Java_study\\system_code\\src\\file\\hhh.txt";

    public static void main6(String[] args) {
        try(FileReader fileReader = new FileReader(name)) {
            while(true){

                int len = fileReader.read();
                if(len==-1){
                    break;
                }
                System.out.print((char)len);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main5(String[] args) throws IOException {
        // 输出流
        FileOutputStream fileOutputStream = new FileOutputStream(name,true);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
// 输出任意数据类型
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeByte(1);

    }
    public static void main4(String[] args) {
        try(OutputStream outputStream = new FileOutputStream(name)) {
            byte[] bytes="hellopanghuhhhh".getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main3(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(name);
        //必须将fileInputStream作为构造参数才能使用
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        //可以读取任意具体的类型数据
        dataInputStream.readBoolean();
        dataInputStream.readInt();
        dataInputStream.readUTF();

    }
    public static void main2(String[] args) throws IOException {
        // 新建一个 BufferedInputStream 对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\bit\\Java_study\\system_code\\src\\file\\hhh.txt"));
        // 读取文件的内容并复制到 String 对象中
        //该api在java1.8没有
        //String result = new String(bufferedInputStream.readAllBytes());
        //System.out.println(result);

    }
    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("D:\\bit\\Java_study\\system_code\\src\\file\\hhh.txt")) {
            System.out.println("Number of remaining bytes:"
                    + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
