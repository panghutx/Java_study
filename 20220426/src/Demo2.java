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
    public static ListNode reverse(MyLinkedList list, int start, int end){
        ListNode cur=list.head;
        ListNode prev = null;

        for(int i=start;i<end;i++){
            ListNode curNext = cur.next;
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }

        return prev;

    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);

        myLinkedList.headDisplay(reverse(myLinkedList, 0, myLinkedList.size()));


    }
}
