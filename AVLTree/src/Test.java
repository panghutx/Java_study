import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;



public class Test {
    static ArrayList<Integer> arrayList1 = new ArrayList<>();
    static ArrayList<Integer> arrayList2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        AVLTree avlTree = new AVLTree();
        Util util = new Util();
        util.write();
        util.read(arrayList1,arrayList2);

        //构建树
        for (int i = 0; i < arrayList1.size(); i++) {
            boolean add = avlTree.add(arrayList1.get(i));
        }
        long begin = System.currentTimeMillis();
        //查找元素
        int count=0;//查找到的次数
        for (int i = 0; i < arrayList2.size(); i++) {
            boolean contains = avlTree.contains(arrayList2.get(i));
            if(contains==true){
                count++;
            }
        }
        long end = System.currentTimeMillis();
        long times = end-begin;
        System.out.println("树的高度为"+avlTree.height(avlTree.root));
        System.out.println("比较了"+avlTree.compare+"次");
        System.out.println("查找到"+count+"个");
        System.out.println("耗时"+times+"ms");

        //输出文件
        try(Writer writer = new FileWriter("d://out.txt")){
            writer.write("h="+avlTree.height(avlTree.root)+",");
            writer.write("m="+avlTree.compare+",");
            writer.write("s="+times+"ms");
            System.out.println("输出文件已保存到d:\\out.txt");
        }
    }

}
