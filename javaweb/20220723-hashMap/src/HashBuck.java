import javax.swing.tree.TreeNode;

public class HashBuck {

    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

        public Node[] array;
        public int usedSize;//记录 当前哈希桶当中 有效数据的个数

        private static final double DEFAULT_LOAD_FACTOR = 0.75; //负载因子

    public HashBuck() {
        this.array = new Node[10];
        this.usedSize = 0;
    }
    public boolean isFull(){
        return usedSize*1.0/array.length>=0.75;
    }

    /**
     * 存储key val
     * @param key
     * @param val
     * @return
     */
    public void put(int key,int val) {
        Node node = new Node(key,val);

        //确定数组中的位置
        int index = key%this.array.length;
        Node cur = array[index];
        //检查数组中链表是否存在key
        while(cur!=null){
            if(array[index].key==key){
                array[index].val=val;
                return;
            }
            cur=cur.next;
        }
        //头插
        node.next=array[index];
        array[index]=node;
        this.usedSize++;

        if(isFull()){
            grow();
        }
    }


    private void grow() {

        Node[] newArray = new Node[2* array.length];
        //重新的哈希
        /**
         * 1. 遍历数组的每个元素的链表
         * 2. 每遍历到一个节点，就重新哈希  key % len
         * 3. 进行头插法
         */

        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while(cur!=null){
                int index = cur.key % newArray.length;
                Node newNode = cur;
                //头插
                newNode.next=newArray[index];
                newArray[index]=newNode;
                cur=cur.next;
            }
        }
        this.array = newArray;
    }

    /**
     * 通过key值 获取val 值
     * @param key
     * @return
     */
    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
       while(cur!=null){
           if(cur.key==key){
               return cur.val;
           }
           cur=cur.next;
        }
        return -1;
    }
}