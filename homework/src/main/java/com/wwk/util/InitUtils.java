package com.wwk.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 初始化txt文件数据，n设置的800，m设置的15000
 *      1.运行main方法生成要输入的txt数据
 * @author wwk
 * @since 2022/10/6
 */
public class InitUtils {

    public final static String PATH = "D:";

    public static void main(String[] args) {
        File file = new File(PATH + "/input.txt");
        initData(file);
//        System.out.println(readData(file));
    }

    private static void initData(File file) {
        int n = 800;
        int m = 15000;
//        File file = null;
        FileWriter fr = null;
//        file = new File("D:/Users/RUI/Desktop/test2.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fr = new FileWriter(file);

            //1.写入n
            fr.write(n + "");
            //写入n的数据
            int lineNum = 100;
            for (int i = 0; i < n; i++) {
                if (i % 100 == 0) {
                    fr.write("\n");
                    fr.flush();
                }
                Random random = new Random();
                int data = random.nextInt(50000);//生成随机数
                fr.write(data + ",");//向文件中写内容
            }
            fr.write("\n");

            //2.写入m
            fr.write(m + "");
            for (int i = 0; i < m; i++) {
                if (i % 100 == 0) {
                    fr.write("\n");
                    fr.flush();
                }
                Random random = new Random();
                int data = random.nextInt(50000);//生成随机数
                fr.write(data + ",");//向文件中写内容
            }
            System.out.println("写数据成功！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<int[]> readData(File file) {
        int n = 0;
        int m = 0;
        ArrayList<int[]> res = new ArrayList<>();
//        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            n = Integer.parseInt(br.readLine());
            //节点数组
            int[] nodes = new int[n];
            for (int i = 0; i < n; ) {
                int j = 0;
                if ((s = br.readLine()) != null) {
                    String[] split = s.split(",");
                    while (j < 100) {
                        nodes[i++] = Integer.parseInt(split[j++]);
                    }
                }
            }
            res.add(nodes);
//            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
//                result.append(System.lineSeparator() + s);
//            }

            //2.读取m
            m = Integer.parseInt(br.readLine());
            int[] nums = new int[m];
            for (int i = 0; i < m; ) {
                int j = 0;
                if ((s = br.readLine()) != null) {
                    String[] split = s.split(",");
                    while (j < 100) {
                        nums[i++] = Integer.parseInt(split[j++]);
                    }
                }
            }
            res.add(nums);
            br.close();
            System.out.println("数据读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
