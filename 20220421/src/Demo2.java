/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: panghu
 * Date: 2022-04-21
 * Time: 21:55
 */
public class Demo2 {

        public static boolean isPalindrome(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<s.length();i++){
                //将合规字符丢尽stringBuilder
                if(Character.isLetterOrDigit(s.charAt(i))){
                    stringBuilder.append(i);
                }
            }
            StringBuilder stringBuilderReverse = new StringBuilder(stringBuilder).reverse();
            return (stringBuilderReverse.toString()).equals((stringBuilder.toString()));

        }
        public static void main(String[] args) {
            String str = "A man, a plan, a canal: Panama";
            System.out.println(isPalindrome(str));
        }
    }

