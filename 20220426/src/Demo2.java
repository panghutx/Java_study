import java.util.LinkedList;
import java.util.List;

//节点
class ListNode{
    public int val;
    //next存储的是下一个节点的地址，所以类型是节点类型
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
    class MyLinkedList {

    public ListNode head; //链表的头引用

    public void creatList(){
        ListNode listNode1 = new ListNode(22);
        ListNode listNode2 = new ListNode(22);
        ListNode listNode3 = new ListNode(22);
        ListNode listNode4 = new ListNode(22);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        this.head=listNode1;
        System.out.println();
    }
    //打印链表
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //根据头节点打印链表
    public void headDisplay(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    //查找关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data){
        ListNode node1=new ListNode(data);
        node1.next=this.head;
        this.head=node1;
    }
    //尾插法
    //!!!!尾插法的第一次插入必须判断!!!可能会空指针异常
    public void addLast(int data){
        ListNode node2=new ListNode(data);
        if(this.head==null){
            this.head=node2;
        }else{
            ListNode cur=this.head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node2;
        }

    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            return;
        }
        if(index==0) {
            addFirst(data);
            return;
        }
        if(index==size()) {
            addLast(data);
            return;
        }
        ListNode cur = toFind(index);
        ListNode node=new ListNode(data);
        node.next=cur.next;
        cur.next=node;
    }
    //查找cur的位置
    public ListNode toFind(int index){
        ListNode cur=this.head;
        while(index-1!=0){
            cur=cur.next;
            index--;
        }
        return cur;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head==null){  //判断是否为空列表
            System.out.println("单链表为空");
            return;
        }
        if(this.head.val==key){   //判断删除的是否是首元素
            this.head=this.head.next;
        }
        ListNode cur=this.head;
        //找到要删除关键字key的前驱
        while(cur.next!=null) { //循环条件要注意下

            if(cur.next.val==key){
                cur.next=cur.next.next;
            }
            cur=cur.next;
        }

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

        if(this.head==null){  //判断是否为空列表
            System.out.println("单链表为空");
            return;
        }

        ListNode cur=this.head.next;
        ListNode prev=this.head;
        while(cur!=null){
            if(cur.val==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        //判断头节点是否为要删除的节点
        if(this.head.val==key){
            this.head=this.head.next;
        }

    }
    //得到单链表的长度
    public int size(){
        ListNode cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }


    public void clear(){
        while (this.head!=null){
            ListNode curNext=this.head;
            this.head.next=null;
            this.head=curNext;
        }
    }

}

public class Demo2 {
    //2.链式存储
    //传入链表list和要反转的首位位置[start,end)
    public static ListNode reverse(ListNode head, int start, int end){
        ListNode cur=head;  //定义一个节点指向第一个节点
        ListNode prev = null; //定义一个空节点
        //创建变量i为start，当i小于end，进入循环
        for(int i=start;i<end;i++) {
            ListNode curNext = cur.next; //定义节点curNext指向cur的next引用
            cur.next=prev; //prev节点赋值给cur的next引用
            prev=cur; //cur赋值给prev
            cur=curNext; //curNext赋值给cur

        }
        return prev; //返回prev节点，也就是反转后链表的第一个节点
    }
    //链式存储，中间截断两部分A和B，A部分元素整体移到B的末尾   AB-->BA
    //传入第一个节点和要开始截断的位置，即B的第一个节点下标
    public static ListNode reverse1(ListNode head,int start){
        ListNode cur = head; //定义一个节点cur指向head节点
        ListNode prev = head; //定义一个节点prev指向head节点
        //循环，让cur节点指向B部分的首元素节点，prev节点指向A部分尾元素节点
        for(int i=0;i<start;i++){
            prev=cur;
            cur=cur.next;
        }
        //定义newHead节点指向cur，也就是翻转后链表的首个节点
        ListNode newHead = cur;
        //令prev的next节点为空，prev为翻转后链表的尾节点
        prev.next=null;
        //从cur位置开始遍历链表，直到cur的next节点为空，也就是遍历到了原链表的尾节点
        while(cur.next!=null){
            cur=cur.next;
        }
        //让cur的next节点指向head节点，也就是原链表的尾节点指向原链表的首个节点，B部分的尾节点指向A部分的首个节点
        cur.next=head;
        //返回新链表的首个节点
        return newHead;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(); //不带头结点的单链表
        //添加元素到链表末尾
        myLinkedList.addLast(1);myLinkedList.addLast(2);myLinkedList.addLast(3);myLinkedList.addLast(4);
        myLinkedList.addLast(5);myLinkedList.addLast(6);myLinkedList.addLast(7);myLinkedList.addLast(8);
        ListNode rst = reverse1(myLinkedList.head,myLinkedList.size()/2); //传入链表的第一个节点和要截断的部分(B部分的首位置)
        myLinkedList.headDisplay(rst); //输出变换后的链表
    }

    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(); //不带头结点的单链表
        //添加元素到链表末尾
        myLinkedList.addLast(1);myLinkedList.addLast(2);myLinkedList.addLast(3);myLinkedList.addLast(4);
        myLinkedList.addLast(5);myLinkedList.addLast(6);myLinkedList.addLast(7);myLinkedList.addLast(8);
        ListNode rst = reverse(myLinkedList.head, 0, myLinkedList.size()); //反转整个链表
        myLinkedList.headDisplay(rst);

    }
}
