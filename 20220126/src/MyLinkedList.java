class ListNode{
    public int val;
    public ListNode prev;
    public ListNode next;
    public ListNode(int val){
        this.val=val;
    }

}

public class MyLinkedList {
    ListNode head;
    ListNode last;


// 2、无头双向链表实现

 //头插法
 public void addFirst(int data){
    ListNode node=new ListNode(data);
     if (this.head != null) {
         node.next = this.head;
         this.head.prev = node;
         this.head=node;
     }else {
         this.head=node;
         this.last=node;
     }

 }
 //尾插法
 public void addLast(int data){
    ListNode node=new ListNode(data);
    if(this.head==null)
        this.head=node;
    else {
        node.prev=this.last;
        this.last.next=node;
        this.last=node;
    }
 }
 //任意位置插入,第一个数据节点为0号下标
 public void addIndex(int index,int data) {
     //index合法性判断  （先跳过）
     int count = 0;
     ListNode cur=this.head;
     int len=size();
     if(index==0) {
         addFirst(data);
         return;
     }
     if(index==len) {
         addLast(data);
         return;
     }
    //可以用while(index!=0) {cur=cur.next; index--;} return cur;来找到cur的位置
     while (count < len) {
         if (count == index) {
             ListNode listNode =new ListNode(data);
             cur.prev.next = listNode;
             listNode.prev=cur.prev;
             listNode.next = cur;
             cur.prev=listNode;
         }
         count++;
         cur = cur.next;

     }
 }
 //查找是否包含关键字key是否在单链表当中
 public boolean contains(int key){
     ListNode cur=this.head;
     while(cur!=null){
         if(cur.val==key)
             return true;
         cur=cur.next;
     }
     return false;

 }
 //删除第一次出现关键字为key的节点
 public void remove(int key) {

     if (this.head == null) {
         return;
     }
     ListNode cur = this.head;
     while (cur != null) {
         if (cur.val == key) {
             if (cur == head) {
                 head = head.next; //...
                 //如果只有一个节点，要删除该节点，避免空指针异常
                 if(head!=null)
                     head.prev = null;
                 else
                     last=null;
             }
             else if (cur == this.last) {
                 this.last = this.last.prev;
                 this.last.next = null;
             }
             else{
                 cur.prev.next=cur.next;
                 cur.next.prev=cur.prev;
             }
             return;
         }
         cur = cur.next;

     }
 }

 //删除所有值为key的节点
 public void removeAllKey(int key) {
     if (this.head == null) {
         return;
     }
     ListNode cur = this.head;
     while (cur != null) {
         if (cur.val == key) {
             if (cur == head) {
                 head = head.next; //...这里有问题，加this后会删除失败，暂时不知道原因！！！
                 //如果只有一个节点，要删除该节点，避免空指针异常
                 if (head != null)
                     head.prev = null;
                 else
                     last = null;
             } else if (cur == this.last) {
                 this.last = this.last.prev;
                 this.last.next = null;
             } else {
                 cur.prev.next = cur.next;
                 cur.next.prev = cur.prev;
             }
             //return;
         }
         cur = cur.next;
     }
 }
 //得到单链表的长度
 public int size() {
     ListNode cur=this.head;
     int count=0;
     while(cur!=null){
         count++;
         cur=cur.next;
     }
     return count;
 }
 public void display() {
    ListNode cur=head;
    while(cur!=null){
        System.out.print(cur.val+" ");
        cur=cur.next;
    }
     System.out.println();
 }
 public void clear() {

    //ListNode curNext=this.head.next; 定义在循环里面，否则链表为空会空指针异常
    while(head!=null){
        ListNode curNext=head.next;
        head.prev=null;
        head.next=null;
        head=curNext.next;
    }
    last=null;
 }

}
