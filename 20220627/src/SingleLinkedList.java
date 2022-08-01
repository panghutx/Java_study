class Node{
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class SingleLinkedList {

    public Node head;
    //初始化链表
    public void init(){
        head = new Node(1);
        Node head1 = new Node(2);
        Node head2 = new Node(3);
        Node head3 = new Node(4);
        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=null;

    }
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        node.next=head;
        head=node;
    }
    //尾插法
    public void addLast(int data){
        Node node =new Node(data);
        Node cur = head;
        //判断链表是否为空，避免空指针异常
        if(cur==null){
            head=node;
            return;
        }
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        node.next=null;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index==0){
            addFirst(data);
        }else if(index==size()-1){
            addLast(data);
        }else {
            //也可以不用prev节点，直接找index-1
            Node cur = head;
            Node prev = new Node(-1);
            int count=0;
            while(cur!=null){
                if(count==index){
                    Node node = new Node(data);
                    prev.next=node;
                    node.next=cur;
                }
                count++;
                prev=cur;
                cur=cur.next;
            }
        }

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = head;
        while (cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        Node cur = head;
        Node prev = new Node(-1);
        //判断删除的是否为头节点
        if(cur.val==key){
            head=head.next;
            return;
        }
        while(cur!=null){
            if(cur.val==key){
                prev.next=cur.next;
                return;
            }
            prev=cur;
            cur=cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = new Node(-1);
        Node cur = head;
        if(head==null) return;

        while(cur!=null){
            if(cur.val==key){
                prev.next = cur.next;
            }else {
                prev=cur;
            }
            cur=cur.next;
        }
        if(head.val==key){
            head=head.next;
        }

    }
    //得到单链表的长度
    public int size(){
        Node cur = head;
        int count=0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public void display(){
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    public void clear(){
        head=null;
    }
}
