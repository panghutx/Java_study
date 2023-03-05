import java.util.*;

public class Test {
    /**
     * 表a，查出分数高于80的前10个同学，降序排列
     */
    //select * from a where score >80 limit 10 order by score desc;

    /**
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     */
    public static boolean isTrue(String str){
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            //如果是左括号
            if(chars[i]=='('||chars[i]=='['||chars[i]=='{'){
                stack.push(chars[i]);
            }else{
                //如果是右括号
                //判断栈是否为空
                if(stack.isEmpty()){
                    return false;
                }
                //判断括号是否匹配
                char top = stack.peek();
                if((top=='('&&chars[i]==')')|| (top=='['&&chars[i]==']')|| (top=='{'&&chars[i]=='}')) {
                     stack.pop();
                }else{
                    return false;
                }
            }
        }
        //判断栈是否为空
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * "aabbscdfsd”统计字符出现次数，并从大到小排序
     */
    public static void count(String str){
        char[] ret = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : ret) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = map.keySet();
        List<Character> list = new ArrayList<>(set);
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(map.get(o1)>map.get(o2)){
                    return 1;
                }else if(map.get(o1)==map.get(o2)){
                    return o1-o2;
                }else{
                    return -1;
                }
            }
        });

        System.out.println(list);

    }
    public static void main(String[] args) {
        //空  左右匹配  首个是右括号  左括号多  右括号多  左右括号不匹配
//        String[] ret = new String[]{"","()",")","(()","([]}","((]))"};
//        for (int i = 0; i < ret.length; i++) {
//            System.out.println(isTrue(ret[i]));
//        }
        //System.out.println(isTrue(s));


    }





}
