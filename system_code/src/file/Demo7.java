package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//以字符的方式来读
public class Demo7 {
    public static void main(String[] args) throws FileNotFoundException {
        try(Reader reader = new FileReader("d://hello.txt")){
            while(true){
                char[] buffer = new char[1024];
                int read = reader.read(buffer);
                if(read==-1){
                    break;
                }
//                for (int i = 0; i < read; i++) {
//                    System.out.println(buffer[i]);
//                }
                String s = new String(buffer,0,read);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
