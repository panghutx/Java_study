
import java.util.Scanner;
import java.util.Stack;
/**
 * Created with IntelliJ IDEA.
 * Description:中缀表达式转后缀表达式后求值计算
 * User: panghutx
 * Date: 2022-04-17
 * Time: 13:45
 */
public class Calculation {

    //第一步：中缀表达式转换成后缀表达式
    public static String turned(String str) {
        Stack<Character> numStack = new Stack<>(); //存放操作数
        Stack<Character> opStack = new Stack<>(); //存放操作符
        char[] chars= str.toCharArray(); //字符串转换成数组

        //中缀-->后缀
        //遍历表达式
        for(char num:chars){
            //1.是数字，就入到numStack栈中
            if(Character.isDigit(num)){
                numStack.push(num);
            //2.是操作符，比较其优先级
            }else if(num=='+'||num=='-'||num=='*'||num=='/'){
                compared(numStack,opStack,num);
            //3.是左括号，入栈
            }else if(num=='('){
                opStack.push(num);
            //4.是右括号，弹出符号栈的栈顶元素，压入numStack，直到遇到左括号
            }else if(num==')'){
                //如果栈顶元素不是左括号，就一直出栈(符号栈)入栈(数字栈)
                while(opStack.peek()!='('){
                    numStack.push(opStack.pop());
                }
                //做到这里说明遇到了左括号
                //弹出左括号(
                opStack.pop();
            }
        }
        //中缀表达式遍历完毕，下面将元素全都存到数字栈，数字栈的逆序就是后缀表达式
        //将符号栈opStack剩余元素弹出并压入numStack
        while(!opStack.isEmpty()){
            numStack.push(opStack.pop());
        }
        //将栈中元素弹出，一次存入字符串并逆序，逆序结果便是后缀表达式
        StringBuilder stringBuilder = new StringBuilder();
        while(!numStack.isEmpty()){
            stringBuilder.append(numStack.pop());
        }
        //逆序
        stringBuilder.reverse();
        //返回后缀表达式
        return stringBuilder.toString();
    }

    //对操作符入栈的处理
    public static void  compared(Stack<Character> numStack,Stack<Character> opStack,char num){
        //1.如果运算符栈为空，直接将运算符入栈
        if(opStack.empty()){
            opStack.push(num);
            return;
        }
        //2.栈不为空，该元素优先级高于栈顶元素，也入栈
        char peek = opStack.peek();
        if(peek=='('||getPriorityValue(num)>getPriorityValue(peek)){
            opStack.push(num);
        }else {
            //3.否则，将栈顶元素弹出压入numStack
            numStack.push(opStack.pop());
            //再次比较当前元素
            compared(numStack, opStack, num);
        }

    }
    //为运算符赋值（比较优先级的重要一步）
    private static int getPriorityValue(char c) {
        if (c == '+' || c == '-')
            return 0;
        if (c == '*' || c == '/')
            return 1;
        //不是+-*/就抛异常
        throw new RuntimeException("非法操作符");
    }
    //加减乘除四则运算
    public static int stored(char num,int endVal,int firstVal) {
        switch(num){
            case '+':
                return firstVal+endVal;  //左操作数+右操作数   （次栈顶元素+栈顶元素）
            case '-':
                return firstVal-endVal; //左操作数-右操作数   （次栈顶元素-栈顶元素）
            case '*':
                return firstVal*endVal; //左操作数*右操作数   （次栈顶元素*栈顶元素）
            case '/':
                return firstVal/endVal; //左操作数/右操作数   （次栈顶元素/栈顶元素）
            default:
                throw new RuntimeException("非法操作符"); //非+-*/，抛出异常
        }

    }

    //第二步：对后缀表达式求值计算
    public static int evaluation(String turned){
        Stack<Integer> resultStack = new Stack<>(); //新建一个栈，用于存放数字
        char[] chars = turned.toCharArray(); //将后缀表达式存入数组
        //遍历数组
        for(char num:chars){
            //当遍历的是数字，入栈
            int val=0;
            if(Character.isDigit(num)){
                resultStack.push(Integer.valueOf(String.valueOf(num)));
            }else {
                //不是数字，弹出栈中的两个元素，第一个做为右操作数，第二个作为左操作数，将两数运算结果入栈
                int endVal = resultStack.pop();//得到右操作数
                int firstVal = resultStack.pop();//得到左操作数
                int ret = stored(num,endVal,firstVal); //计算运算结果
                resultStack.push(ret); //将运算结果入栈
            }

        }
        return resultStack.pop(); //弹出栈顶元素，该结果就是最后的值
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入表达式：");
        String ret = scanner.next(); //输入表达式
        String turned = turned(ret); //得到后缀表达式
        System.out.println("后缀表达式："+turned); //输出后缀表达式
        System.out.println("求值结果:"+evaluation(turned));//得到后缀表达式计算后的值

    }
}
