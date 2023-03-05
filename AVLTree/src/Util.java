import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Util {

    File file = new File("d://test.txt");


    public void write() throws IOException {

        file.createNewFile();

        try (Writer writer = new FileWriter(file)) {
            Scanner scanner = new Scanner(System.in);
            //读入n个数据
            System.out.println("请输入整数n，表示数据集合的大小-->");
            int n = scanner.nextInt();
            writer.write(n + "\r\n");

            int[] ans = new int[n];
            Random random = new Random();
            //生成n个随机数
            for (int i = 0; i < n; i++) {
                ans[i] = random.nextInt(50000);
            }
            writer.write(Arrays.toString(ans));
            writer.write("\r\n");

            //读入m个数据
            System.out.println("请输入整数m，表示要查找的数据集合的大小-->");
            int m = scanner.nextInt();
            writer.write(String.valueOf(m) + "\r\n");

            int[] toFind = new int[m];
            //生成n个随机数
            for (int i = 0; i < m; i++) {
                toFind[i] = random.nextInt(50000);
            }
            writer.write(Arrays.toString(toFind));
            System.out.println("输入成功，输入文件已保存到"+file.getAbsolutePath());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(ArrayList<Integer> arrayList1,ArrayList<Integer> arrayList2) throws FileNotFoundException {

        try (Reader reader = new FileReader(file)) {
            char[] buffer = new char[1024];
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int len = reader.read(buffer);
                if (len == -1) {
                    break;
                }
                stringBuffer.append(buffer, 0, len);
            }
            //读取数据结合
            int start = stringBuffer.indexOf("[");
            int end = stringBuffer.indexOf("]");
            String[] split = stringBuffer.substring(start + 1, end).split(", ");
            for (String s:split) {
                arrayList1.add(Integer.valueOf(s));
            }

            //System.out.println(arrayList1);

            //读取要查找的数据集合
            int start2 = stringBuffer.indexOf("[",end);
            int end2 = stringBuffer.indexOf("]",end+1);
            String[] split2 = stringBuffer.substring(start2 + 1, end2).split(", ");
            for (String s:split2) {
                arrayList2.add(Integer.valueOf(s));
            }
            //System.out.println(arrayList2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
