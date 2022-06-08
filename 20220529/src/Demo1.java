import java.util.Locale;

public class Demo1 {
    String str = new String("good");
    char[ ] ch = { 'a' , 'b' , 'c' };
    public static void main1(String args[]){
        Demo1 ex = new Demo1();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[ ]){
        str = "test ok";
        ch[0] = 'g';
    }

    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
        String str = "avfdfT";
        str.toUpperCase();
    }

}
