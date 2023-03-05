package com.wwk;

import com.wwk.AVL.AVLTree;
import com.wwk.util.InitUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * n个数据构建AVL树，从中寻找m条数据。
 *      1.运行InitUtils中的main方法生成输入的数据input.txt
 *      2.然后运行这个类就会输出信息到文件output.txt（AVL树高度，查询次数，查询时间（毫秒））
 * @author wwk
 * @since 2022/10/6
 */
public class SearchDemo {
    private int high = 0;
    private int[] nodes;
    private int[] searchNum;
    AVLTree avlTree = null;

    private File file = new File(InitUtils.PATH + "/input.txt");

    {
        List<int[]> ints = InitUtils.readData(file);
        nodes = ints.get(0);
        searchNum = ints.get(1);
        initTree();
    }

    public static void main(String[] args) throws IOException {
        SearchDemo searchDemo = new SearchDemo();
        long costTime = 0;
        //测试花费时间
        long startTime = System.currentTimeMillis();
        searchDemo.search();
        long endTime = System.currentTimeMillis();
        costTime = endTime - startTime;
        System.out.println("----costTime: " + costTime + " 毫秒");
        //输出到文件
        searchDemo.output(costTime);
    }

    private void output(long costTime) {
        File file = new File(InitUtils.PATH + "/output.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write("h = " + high + "\r");
            fw.write("m = " + avlTree.getLookTime() + "\r");
            fw.write("t = " + costTime + "ms\r");
            fw.flush();
        } catch (IOException e) {
            try {
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    /**
     * 初始化AVL树
     */
    public void initTree() {
        avlTree = new AVLTree();
        for (int node : nodes) {
            avlTree.insert(node);
        }
        high = avlTree.getHeight();
        System.out.println("AVL树构建完毕");
    }

    /**
     * 在AVL树中搜索数组m
     */
    public void search() {
        int count = 0;
        for (int num : searchNum) {
            AVLTree.AVLNode res = avlTree.search(num);
            if (res != null) {
                count++;
            }
        }
        System.out.println("命中：" + count);
    }

}
