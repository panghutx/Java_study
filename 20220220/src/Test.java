import java.util.*;
class Node {
    public char val;
    Node left;
    Node right;

    public Node(char val) {
        this.val = val;
    }

}
class BinaryTree {
    public Node creatBinaryTree(){
        //穷举法创建二叉树
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeE = new Node('E');
        Node nodeF = new Node('F');
        Node nodeG = new Node('G');
        Node nodeH = new Node('H');
        nodeA.left=nodeB;
        nodeB.left=nodeD;
        nodeC.left=nodeF;
        nodeB.right=nodeE;
        nodeE.right=nodeH;
        nodeA.right=nodeC;
        nodeC.right=nodeG;
        return nodeA;
    }
    // 前序遍历
    void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // 中序遍历
    void inOrderTraversal(Node root){
        if(root==null){
            return;
        }

        preOrderTraversal(root.left);
        System.out.print(root.val);
        preOrderTraversal(root.right);

    }
    // 后序遍历
    void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val);
    }

    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(Node root){
        if(root==null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);

    }
    // 子问题思路-求结点个数
    int getSize2(Node root){
        if(root==null){
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }

    // 遍历思路-求叶子结点个数
    //
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    // 子问题思路-求叶子结点个数
//    int getLeafSize2(Node root){
//        if(root==null){
//            return 0;
//        }
//
//    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1) return 1;
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    //查找结点
//    Node find(Node root, char val){
//    }
    // 获取二叉树的高度
    int getHeight(Node root){
        if(root==null) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
public class Test {
    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    public static void main2(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node node= binaryTree.creatBinaryTree();
        binaryTree.preOrderTraversal(node);
        binaryTree.getSize1(node);
        System.out.println(BinaryTree.size);
        System.out.println(binaryTree.getSize2(node));
        binaryTree.getLeafSize1(node);
        System.out.println(BinaryTree.leafSize);
        System.out.println("=======");
        System.out.println(binaryTree.getKLevelSize(node,3));
        System.out.println(binaryTree.getHeight(node));

    }
}
