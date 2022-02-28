import java.util.Arrays;

class Stack{
    public int[] elem;
    public int top;

    public Stack(){
        this.elem=new int[10];
    }
    public boolean isFull(){
        return this.elem.length==this.top;
    }
    public void push(int item){
        //1.判断是否满了
        if(isFull()){
            this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[top++]=item;
    }
}

public class Test {
    public static void main(String[] args) {

    }
}
