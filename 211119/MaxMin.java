public class MaxMin {
    public static void main(String[] args) {
        int a=20;
        int b=10;
        int c=30;
        int max=0;
        int min=0;
        if(a>b){
            if(a>c){
                max=a;
                
            }else {
                max=c;
            }
            if(b>c){
                min=c;
            }else {
                min=b;
            }
        }else {

            if(b>c) {
                max=b;
            }else {
                max=c;
            }
            if(a>c){
                min=c;
            }else {
                min=a;
            }
        }
        System.out.println("最大值是"+max);
        System.out.println("最小值是"+min);

    }
}
