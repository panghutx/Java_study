//public class Test{
//    static int cnt = 6;
//    static{
//        cnt += 9;
//    }
//    public static void main(String[] args){
//        System.out.println("cnt"+ cnt);
//    }
//    static{
//        cnt /=3;
//    };
//}

//非静态方法不能访问静态变量
public class Test {
    public int aMethod(){
        //static int i = 0;
        int i=0;
        i++;
        return i;
    }
    public static void main(String args[]){
        Test test = new Test();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
}
