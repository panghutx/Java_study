

public class TestDemo {

    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    //链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        //先确定链表长度
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        //移动头节点，确定移动次数与k之间的关系
        for(int i=0;i<count-k;i++){
            head=head.next;
        }
        return head;
    }
    //快慢指针
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode firstHead=head;
        ListNode endHead=head;
        while(firstHead!=null && k>0){
            firstHead=firstHead.next;
            k--;
        }
        while(firstHead!=null){
            firstHead=firstHead.next;
            endHead=endHead.next;
        }
        return endHead;
    }

    }

