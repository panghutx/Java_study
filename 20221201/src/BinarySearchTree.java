import java.util.Arrays;


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {
    public Node root = null;


    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if(cur.val < key) {
                cur = cur.right;
            }else if(cur.val == key) {
                return cur;
            }else {
                cur = cur.left;
            }
        }
        return null;//代表没有这个数据
    }

    public boolean insert(int val) {
        //1，如果root为null，插入结点即可
        if(root==null){
            root = new Node(val);
            return true;
        }
        //2.遍历二叉树，直到叶子结点
        Node parent = root;
        Node cur = root;
        while(cur!=null){
            if(cur.val<val){
                //往右面插入
                parent=cur;
                cur=cur.right;
            }else if(cur.val>val){
                //往左面插入
                parent=cur;
                cur=cur.left;
            }else{
                //插入节点已存在
                return false;
            }
        }
        //cur为空，判断插入元素与父节点的大小关系
        if(parent.val<val){
            parent.right=new Node(val);
        }else {
            parent.left=new Node(val);
        }
        return true;
    }


    public void remove(int key) {
        //1.没结点直接return
        if(root==null){
            return;
        }
        Node cur = root;
        Node parent =null;
        while(cur!=null){
            if(key<cur.val){
                parent=cur;
                cur=cur.left;
            }else if(key==cur.val){
                removeNode(cur,parent);
                break;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
    }

    public void removeNode(Node cur,Node parent) {
        //3种情况：1.cur.left==null 2.cur.right==null 3.cur.left!=null&&cur.right!=null
        //1.cur.left==null
        //1.1 cur==root
        if(cur.left==null){
            if(cur==root){
                root.right=cur.right;
                //1.2 cur!=root
            }else {
                //1.2.1 parent.left=cur
                if(parent.left==cur){
                    parent.left=cur.right;
                }else{
                    //1.2.2 parent.right=cur
                    parent.right=cur.right;
                }
            }

        }
        //2.cur.right==null
        else if(cur.right==null){
            //2.1 cur==root
            if(cur==root){
                root.left=cur.left;
                //2.2 cur!=root
            }else{
                if(parent.left==cur){
                    parent.left=cur.left;
                }else{
                    parent.right=cur.left;
                }
            }
        }
        //3. cur.left!=null && cur.right!=null
        else{
            //找cur的左子树的最大值或cur的右子树的最小值
            Node targetParent = cur;
            //这里找的是右子树的最小值
            Node target = cur.right;
            while(target.left!=null){
                targetParent=target;
                target=target.left;
            }
            //找到右子树的最小值target
            cur.val = target.val;
            //target == targetParent.right
            if(target == targetParent.right){
                targetParent.right= target.right;
                ////target == targetParent.left
            }else{
                targetParent.left= target.right;
            }

        }
    }

    public void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);

    }

    public static void main(String[] args) {
        int[] array = {10,8,19,3,9,4,7};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println("插入重复的数据");
        System.out.println(binarySearchTree.insert(3));
        System.out.println("删除数据：");
        binarySearchTree.remove(4);
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.root);

    }
}