import java.util.Arrays;
import java.util.Scanner;

class Test{
    static void hello(){
        System.out.println(123);
    }
}
public class Demo9 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/6736cc3ffd1444a4a0057dee89be789b?orderByHotValue=1&page=1&onlyReference=false
     * 来源：牛客网
     *
     * 牛牛举办了一次编程比赛,参加比赛的有3*n个选手,每个选手都有一个水平值a_i.现在要将这些选手进行组队,一共组成n个队伍,即每个队伍3人.牛牛发现队伍的水平值等于该队伍队员中第二高水平值。
     * 例如:
     * 一个队伍三个队员的水平值分别是3,3,3.那么队伍的水平值是3
     * 一个队伍三个队员的水平值分别是3,2,3.那么队伍的水平值是3
     * 一个队伍三个队员的水平值分别是1,5,2.那么队伍的水平值是2
     * 为了让比赛更有看点,牛牛想安排队伍使所有队伍的水平值总和最大。
     * 如样例所示:
     * 如果牛牛把6个队员划分到两个队伍
     * 如果方案为:
     * team1:{1,2,5}, team2:{5,5,8}, 这时候水平值总和为7.
     * 而如果方案为:
     * team1:{2,5,8}, team2:{1,5,5}, 这时候水平值总和为10.
     * 没有比总和为10更大的方案,所以输出10.
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        long y=0l;
        Long[] num=new Long[3*x];
        for (int i = 0; i < 3*x; i++) {
            y = scanner.nextLong();
            num[i]=y;
        }
        long ret=0l;
        Arrays.sort(num);
        for (int i = 0; i < x; i++) {
            ret+=num[num.length-(2*(i+1))];
        }
        System.out.println(ret);

        Test.hello();
    }
}
