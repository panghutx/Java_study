public class Demo8 {
    public int StrToInt(String str) {
        int sum=0;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)>'9'||str.charAt(i)<'0'){
                return 0;
            }
        }

        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();
        System.out.println(demo8.StrToInt("+1a23"));
    }
}
