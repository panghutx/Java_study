import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 加一
 * 将数组转换成整数，然后+1，然后再转换成数组
 * 垃圾想法！！！
 * User: panghu
 * Date: 2022-04-19
 * Time: 15:36
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        //1.先将数组存放到StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }
        //2.将StringBuilder转换成字符串，再将字符串转换成整数，再+1
        String str = stringBuilder.toString();
        int a = Integer.parseInt(str);
        a+=1;
        //3.整数转换成字符串
        str = String.valueOf(a);
        //System.out.println(str);
        int len = str.length();
        //4.字符串存入数组
        int[] arr1 = new int[len];
        for(int j=0;j<len;j++){
            arr1[j]=str.charAt(j);
        }
    }
}

