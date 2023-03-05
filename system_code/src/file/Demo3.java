package file;

import java.io.File;
import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        File f = new File("./");
        System.out.println(Arrays.toString(f.list()));
        System.out.println(Arrays.toString(f.listFiles()));
    }
}
