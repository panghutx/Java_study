import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 思路： 找9
 * 1.从最后一位找，如果不是9，将其加+1，将其后面的元素置为0
 * 3.如果全是9，新建一个n+1长度的数组，将第一位改为1，其余权威0  999-》 1000
 * User: panghu
 * Date: 2022-04-19
 * Time: 20:12
 */
public class Demo2 {

    public static int[] plusOne(int[] arr) {
        int n = arr.length;
        //从后遍历字符串，非9加1，其后置0
        for(int i=n-1;i>=0;i--){
            if(arr[i]!=9){
                arr[i]+=1;
                for(i=i+1;i<n;i++){
                    arr[i]=0;
                }
                return arr;
            }
        }
        //走到这里，说明全位9，新建一个n+1长度的数组，第一位置为1
        int [] newArr = new int[n+1];
        newArr[0]=1;
        return newArr;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{9,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }


}
