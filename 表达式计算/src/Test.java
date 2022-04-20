import java.util.Stack;

public class Test {
    /**
     * 后缀表达式的计算机求值：
     * 与前缀表达式类似，只是顺序是从左至右：
     * 从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，
     * 弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 op 栈顶元素），
     * 并将结果入栈；重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果。
     * @param zhongExpression
     * @return
     */
    public static int calculateQianHou(String zhongExpression) {

        //先把中缀表达式转后缀表达式
        String HouExpression = zhong2hou(zhongExpression);

        char[] chars = HouExpression.toCharArray();

        Stack<Integer> resultValues  = new Stack<>();

        for (char theChar : chars){
            //从左至右扫描表达式，遇到数字时，将数字压入堆栈
            if (Character.isDigit(theChar))
                resultValues.push(Integer.valueOf(String.valueOf(theChar)));
                //遇到运算符时,弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 op 栈顶元素）
                // (注意前缀表达式计算是栈顶元素 op 次顶元素)
            else {
                int a = resultValues.pop();
                int b = resultValues.pop();
                resultValues.push(calculate(b,a,theChar));
            }
        }
        return resultValues.pop();
    }

    /**
     * 将中缀表达式转换为后缀表达式：
     与转换为前缀表达式相似，遵循以下步骤：
     * (1) 初始化两个栈：运算符栈S1和储存中间结果的栈S2；
     * (2) 从左至右扫描中缀表达式；
     * (3) 遇到操作数时，将其压入S2；
     * (4) 遇到运算符时，比较其与S1栈顶运算符的优先级：
     * (4-1) 如果S1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     * (4-2) 否则，若优先级比栈顶运算符的高，也将运算符压入S1（注意转换为前缀表达式时是优先级较高或相同，而这里则不包括相同的情况）；
     * (4-3) 否则，将S1栈顶的运算符弹出并压入到S2中，再次转到(4-1)与S1中新的栈顶运算符相比较；
     * (5) 遇到括号时：
     * (5-1) 如果是左括号“(”，则直接压入S1；
     * (5-2) 如果是右括号“)”，则依次弹出S1栈顶的运算符，并压入S2，直到遇到左括号为止，此时将这一对括号丢弃；
     * (6) 重复步骤(2)至(5)，直到表达式的最右边；
     * (7) 将S1中剩余的运算符依次弹出并压入S2；
     * (8) 依次弹出S2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式（转换为前缀表达式时不用逆序）。
     * @return
     */
    private static String zhong2hou(String expression) {

        //(1) 初始化两个栈：运算符栈S1和储存中间结果的栈S2；
        Stack<Character> ops = new Stack<>();
        Stack<Character> resultValues = new Stack<>();

        char[] chars = expression.toCharArray();

        //(2) 从左至右扫描中缀表达式；
        for (char theChar : chars){
            //(3) 遇到操作数时，将其压入S2；
            if (Character.isDigit(theChar))
                resultValues.push(theChar);
                //(4) 遇到运算符时，比较其与S1栈顶运算符的优先级：
            else if (theChar == '+' || theChar == '-' || theChar == '*' || theChar == '/')
                dealTheChar(ops,resultValues,theChar);
                //(5) 遇到括号时：
                //(5-1) 如果是左括号“(”，则直接压入S1；
            else if (theChar == '(')
                ops.push(theChar);
                //(5-2) 如果是右括号“)”，则依次弹出S1栈顶的运算符，并压入S2，直到遇到左括号为止，此时将这一对括号丢弃；
            else if (theChar == ')'){
                char opsChar  = ops.pop();
                while (opsChar != '(') {
                    resultValues.push(opsChar);
                    opsChar  = ops.pop();
                }
            }
        }

        //(7) 将S1中剩余的运算符依次弹出并压入S2；
        while (!ops.isEmpty())
            resultValues.push(ops.pop());

        //(8) 依次弹出S2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式（转换为前缀表达式时不用逆序）。
        StringBuilder exp = new StringBuilder();
        while (!resultValues.empty())
            exp.append(resultValues.pop());

        return reverseString(exp.toString());
    }

    private static void dealTheChar(Stack<Character> ops, Stack<Character> resultValues, char theChar) {
        //(4-1) 如果S1为空，则直接将此运算符入栈;
        if (ops.empty()) {
            ops.push(theChar);
            return;
        }
        char popTheChar = ops.pop().charValue();
        //(4-1) 如果S1为空，或栈顶运算符为右括号“(”，则直接将此运算符入栈;
        //(4-2) 否则，若优先级比栈顶运算符的高，也将运算符压入S1（注意转换为前缀表达式时是优先级较高或相同，而这里则不包括相同的情况）
        if (popTheChar == '(' || getPriorityValue(theChar) > getPriorityValue(popTheChar)) {
            ops.push(popTheChar);
            ops.push(theChar);
        }
        //(4-3) 否则，将S1栈顶的运算符弹出并压入到S2中
        else {
            resultValues.push(popTheChar);
            //，再次转到(4-1)与S1中新的栈顶运算符相比较;
            dealTheChar(ops, resultValues, theChar);
        }

    }

    private static int getPriorityValue(char c) {
        if (c == '+' || c == '-')
            return 0;
        if (c == '*' || c == '/')
            return 1;
        throw new RuntimeException("非法操作符");
    }

    private static int calculate(int a,int b,char c) {
        switch (c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                throw new RuntimeException("非法操作符");
        }
    }

    private static String reverseString(String string) {

        int n = string.length();
        char[] chars = string.toCharArray();
        for (int i = 0; i < n/2; i++) {
            char temp = chars[i];
            chars[i] = chars[n-1-i];
            chars[n-1-i] = temp;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        System.out.println(zhong2hou("1+2*(6+4)/2").toString());
        System.out.println(calculateQianHou("1+3*(2+3)/5"));
    }
}
