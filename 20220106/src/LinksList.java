class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val=val;
    }
}
public class LinksList {
    public Node head;

    // 1、无头单向非循环链表实现

    //头插法
    public void addFirst(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            return;
        }
        node.next=this.head;
        this.head=node;
    }
      //尾插法
    public void addLast(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            return;
        }
        Node cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }
      //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){

        if(index<0||index >size()){
            System.out.println("index不合法");
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==this.size()){
            addLast(data);
            return;
        }
        Node cur=findIndexSubOne(index);
        Node node=new Node(data);

        node.next=cur.next;
        cur.next=node;

        }


    public Node findIndexSubOne(int index){
        int count=0;
        Node cur=this.head;
        while(count!=index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }
       //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){

        Node cur=this.head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
     //找要删除的节点的前驱
    public Node searchPrev(int key){
        Node prev=this.head;
        while(prev.next!=null){
            if(prev.next.val==key){
                return prev;
            }
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head.val==key){
            this.head=this.head.next;
            return;
        }
        Node prev=searchPrev(key);
        if(prev==null){
            System.out.println("没找到");
            return;
        }

        Node del=prev.next;
        prev.next=del.next;

    }
      //删除所有值为key的节点
    public void removeAllKey(int key){

    }
      //得到单链表的长度
    public int size(){
        int count=0;
        Node cur=this.head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

//    public void clear();

}
class My{
    public static void main(String[] args) {
        LinksList list=new LinksList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.display();
        list.addLast(0);
        list.display();
        list.addIndex(2,3);
        list.display();

    }
        }
