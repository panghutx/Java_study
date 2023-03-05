package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

//以字符的方式来写
public class Demo8 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("d://hello.txt")) {
            writer.write("xyz");
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}
