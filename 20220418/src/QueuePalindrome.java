import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 用队列和栈判断字符串回文
 * User: panghu
 * Date: 2022-04-19
 * Time: 10:15
 */
public class QueuePalindrome {
    public static boolean Palindrome(String str){
        Deque<Character> queue = new ArrayDeque<>(); //创建一个队列
        Stack<Character> stack = new Stack<>(); //创建一个栈
        int len = str.length(); //获取字符串长度
        //遍历字符串
        for(int i=0;i<len;i++){
            queue.add(str.charAt(i)); //向队列添加字符串中的第i个元素
            stack.push(str.charAt(i)); //向栈添加字符串中的第i个元素
        }
        //比较要删除的 队列的队首元素  和 栈的栈顶元素 ，一样继续删除，不一样返回false
        while(!queue.isEmpty()&& !stack.isEmpty()){
            if(!queue.remove().equals(stack.pop())){ //比较要删除的元素
                return false; //不一样返回false
            }
        }
        return true; //队列元素和栈元素均为空，返回true
    }
    public static void main(String[] args) {
        //输入一个字符串，判断是否为回文字符串
        System.out.println("请输入一个字符串");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next(); //输入字符串
        System.out.println(Palindrome(str)); //输出返回结果

    }
}
