import java.util.List;

public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addIndex(0,10);
        //linkedList.addIndex(1,20);
        //linkedList.addIndex(2,10);
        linkedList.display();
        linkedList.removeAllKey(10);
        linkedList.display();
    }
    public static class ListNode{
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }

    }
    public ListNode head;
    public ListNode last;

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head==null){
            head=node;
            last=node;
        }else {
            node.next = head;
            head.prev=node;
            head = node;
        }

    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(head==null){
            head=node;
            last=node;
        }else {
            last.next=node;
            node.prev=last;
            last=node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        //判断index的合法性
        if(index<0||index>size()){
            System.out.println("下标不合法");
            return false;
        }
        //头插法
        if(index==0){
            addFirst(data);
            return true;
        }
        //尾插法
        if(index==size()){
            addLast(data);
            return true;
        }
        //其他位置插入
        ListNode cur=head;
        ListNode node = new ListNode(data);
        while(index!=0){
            cur=cur.next;
            index--;
        }
        //cur位置即为index位置
        node.next=cur;
        node.prev=cur.prev.next;
        cur.prev.next=node;
        cur.prev=node;
        return true;

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                //要删除的是头节点
                if(head.val==key){

                    head=head.next;
                    if(head!=null){
                        //链表是否只有一个元素
                        head.prev=null;
                    }

                }else{
                    cur.prev.next=cur.next;
                    //正常情况下
                    if(cur.next!=null){
                        //删除的不是尾巴结点
                        cur.next.prev=cur.prev;

                    }else{
                        last=last.prev;
                    }


                }
                return;

            }
            cur=cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                //要删除的是头节点
                if(head.val==key){

                    head=head.next;
                    if(head!=null){
                        //链表是否只有一个元素
                        head.prev=null;
                    }else {
                        return;
                    }

                }else{
                    cur.prev.next=cur.next;
                    //正常情况下
                    if(cur.next!=null){
                        //删除的不是尾巴结点
                        cur.next.prev=cur.prev;

                    }else{
                        last=last.prev;
                    }


                }


            }
            cur=cur.next;
        }
    }
    //得到单链表的长度
    public int size(){
        int count=0;
        ListNode cur = head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public void display(){
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    public void clear(){
        ListNode cur = head;
        while (cur != null) {

            ListNode curNext = cur.next;

            ///cur.val = null;

            cur.prev = null;

            cur.next = null;

            cur = curNext;

        }

        head = null;

        last = null;
    }
}
