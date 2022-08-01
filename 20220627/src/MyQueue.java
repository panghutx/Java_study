import java.util.LinkedList;
import java.util.Queue;

//用链表来实现一个队列
public class MyQueue {
    static class Node{
        public int val;
        public Node next;


        public Node(int val) {
            this.val = val;
        }
    }
    public Node head;
    public Node tail;
    public int usedSize;

    public void display(){
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
    public void offer(int val){
        Node node = new Node(val);
        if(head==null){
            //队列为空
            head=node;
            tail=node;
        }else {
            //队列不为空
            tail.next=node;
            tail=node;
        }
        usedSize++;
    }

    public int poll(){
        if(head==null){
            //队列为空
            return -1;
        }
        int oldVal = head.val;
        //队列不为空
        //队列只有一个结点
        if(head.next==null){
            head=tail=null;
        }else{
            head=head.next;
            usedSize--;
        }

        return oldVal;
    }

    public int peek(){
        if(head==null){
            return -1;
        }
        return head.val;
    }

    public int size(){
        return usedSize;
    }

    public boolean empty(){
        return usedSize==0;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.size());
        myQueue.display();

    }

}
