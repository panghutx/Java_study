import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:直接求值表达式
 * User: panghutx
 * Date: 2022-04-17
 * Time: 20:16
 */
public class Calculation1 {
    public static int evaluation(String str){
        Stack<Integer> numStack = new Stack<>(); //存放操作数
        Stack<Character> opStack = new Stack<>(); //存放运算符
        char[] chars = str.toCharArray(); //存放字符串的数组
        //遍历中缀表达式
        for(char num:chars){
            if(Character.isDigit(num)){
                numStack.push(Integer.valueOf(String.valueOf(num))); //如果是数字，入numStack
            //如果是操作数，判断优先级
            }else if(num=='+'||num=='-'||num=='*'||num=='/'){
                compared(numStack,opStack,num);
            //如果是'('，直接入栈
            }else if(num=='('){
                opStack.push(num);
            //如果是')',弹出数字栈两个元素，符号栈栈顶元素，求值计算，知道出现'('
            }else{
                while(opStack.peek()!='('){
                    char opMax = opStack.pop(); //弹出符号栈栈顶元素，也就是运算符
                    int endNum = numStack.pop(); //右操作数//栈顶元素
                    int firstNum = numStack.pop(); //左操作数，次栈顶元素
                    int ret = stored(opMax,endNum,firstNum); //求值计算
                    numStack.push(ret); //计算结果入数字栈
                }
                opStack.pop();//弹出'('
            }
        }
        //现在两个栈都满了，该依次出栈，然后求值计算了
        //操作数栈弹出两个，操作符栈弹出一个，求出后压入操作数栈，直到操作符栈为空停止操作
        while(!opStack.isEmpty()){
            char opMax = opStack.pop(); //弹出运算符
            int endNum = numStack.pop(); //弹出右操作数
            int firstNum = numStack.pop(); //弹出左操作数
            int ret = stored(opMax,endNum,firstNum); //求值计算
            numStack.push(ret); //入数字栈
        }
        //返回数字栈栈顶元素，也就是最后结果
        return numStack.pop();
    }
    //优先级比较函数
    public static void compared(Stack<Integer> numStack,Stack<Character> opStack,char num) {
        //如果操作符栈为空，直接入栈(该方法结束的出口）
        if(opStack.isEmpty()){
            opStack.push(num);
            return;
        }
        char peek= opStack.peek();//获取栈顶元素
        //如果栈顶元素是（ 或者栈顶元素优先级小于等于num，入栈
        if(peek=='('||getPriorityValue(peek)<=getPriorityValue(num)){
            opStack.push(num);
        //如果栈顶元素优先级大于num，取出操作符栈的栈顶元素和操作数栈的两个元素，相运算后入栈，再次比较优先级
        }else{
            char opMax = opStack.pop();
            int endNum = numStack.pop();
            int firstNum = numStack.pop();
            int ret = stored(opMax,endNum,firstNum);
            numStack.push(ret);
            //再次比较优先级，直到为空
            compared(numStack,opStack,num);
        }
    }
    //运算符赋值，用于比较优先级的关键一步
    private static int getPriorityValue(char c) {
        if (c == '+' || c == '-')
            return 0;
        if (c == '*' || c == '/')
            return 1;
        throw new RuntimeException("非法操作符"); //非+-*/抛异常
    }

    //求值计算
    public static int stored(char num,int endVal,int firstVal) {
        switch(num){
            case '+':
                return firstVal+endVal;
            case '-':
                return firstVal-endVal;
            case '*':
                return firstVal*endVal;
            case '/':
                return firstVal/endVal;
            default:
                throw new RuntimeException("非法操作符");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入表达式：");
        String ret = scanner.next(); //输入表达式
        System.out.println("求值结果:"+evaluation(ret));//得到后缀表达式计算后的值

    }
}
