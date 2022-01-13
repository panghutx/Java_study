import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

class MyArrayList{
    public int[] elem;
    public int usedSize;
    public MyArrayList(){
        this.elem=new int[10];
        this.usedSize=10;
    }
    //打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    // 在 pos 位置新增元素
    public void add(int pos,int data){
        //判断pos位置是否合法
        if(pos<0||pos>this.usedSize){
            System.out.println("Pos位置不合法");
            return;
        }
        for (int i = this.usedSize-1; i >=pos; i--) {
            this.elem[i+1]=this.elem[i];
            }
        this.elem[pos]=data;
        this.usedSize++;
        }

// 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind==this.elem[i]){
                return true;
            }
        }
        return false;
    }
// 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind==this.elem[i]){
                return i;
            }
        }
        return -1;
    }
// 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>=this.usedSize){
            return -1;
        }
        return this.elem[pos];
    }
// 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos<0||pos>=this.usedSize){
            return;
        }
        this.elem[pos]=value;
    }
//删除第一次出现的关键字key
    public void remove(int key) {
        int index=this.search(key);
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i]=this.elem[i+1];
        }
        this.usedSize--;

    }
// 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
// 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
    }




public class TestDemo {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            list.setPos(i,i);
        }
        list.display();
        list.remove(5);
        list.display();
        System.out.println(list.size());
        list.clear();
        list.display();
    }


}
