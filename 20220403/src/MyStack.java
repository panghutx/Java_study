import java.util.LinkedList;
import java.util.Stack;

public class MyStack {
    static public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); //创建一个栈
        for(char c : s.toCharArray()){  //遍历字符串的每一个字符
            if(c == '(' || c == '[' || c == '{')  //如果是左括号就入栈
                stack.push(c);
            else{ //碰到右括号的情况
                if(stack.isEmpty()) // 栈为空，false
                    return false;
                    // 栈不为空，但栈顶元素不匹配，false
                else if(c == ')' && stack.pop() != '(' || c == ']' && stack.pop() != '[' || c == '}' && stack.pop() != '{')
                    return false;
            }
        }
        // 左括号有剩余
        // 字符序列遍历完，但是栈不为空，false,栈为空，true
        return stack.isEmpty();
    }
    //ReverseRead: read one line of input and write it backward.
    static public void Back(String s){
        Stack<Character> stack = new Stack<>(); //创建一个栈，存放字符
        for(char c:s.toCharArray()){ //遍历字符串
            //将字符串中字符入栈
            stack.push(c);
        }
        for(char c:s.toCharArray()){ //遍历字符串
            //将字符串中字符出栈
            System.out.print(stack.pop());
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        System.out.println(isValid("[(%$#)]")); //1.匹配的情况  true
//        System.out.println(isValid("[(%$#)($]")); //2.不匹配的情况 false
        Back("abcdef"); //1.测试1 输出fedcba
        Back("hello,world"); //2.测试2 输出dlrow,olleh
    }
}
