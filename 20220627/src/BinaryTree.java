import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //穷举法创建一棵二叉树
    public TreeNode createTree() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    // 前序遍历
    void preOrder(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);
        postOrder(root.left);
        postOrder(root.right);
    }

    //前序遍历的子问题思路
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        list.add(root.val);
        List<Integer> leftNode = preorderTraversal(root.left);
        list.addAll(leftNode);
        List<Integer> rightNode = preorderTraversal(root.right);
        list.addAll(rightNode);

        return list;

    }

    // 中序遍历
    void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    //后序遍历
    void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    // 获取树中节点的个数
    public int count;
    //便利思路
    int size(TreeNode root){
        if(root==null) return 0;
        count++;
        size(root.left);
        size(root.right);
        return count;
    }
    //获取树中节点的个数  子问题思路
    int size1(TreeNode root){
        if(root==null) {
            return 0;
        }

        return size1(root.left)+size1(root.right)+1;
    }

    // 子问题思路  获取叶子节点的个数
    int getLeafNodeCount(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        return getLeafNodeCount(root.left)+getLeafNodeCount(root.right);
    }
    // 遍历思路-求叶子结点个数
    int getLeafNodeCount1(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) count++;
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
        return count;
    }
    // 获取第K层节点的个数
    int getKLevelNodeCount(TreeNode root,int k){
        if(root==null) return 0;
        if(k==1) return 1;
        return getKLevelNodeCount(root.left, k-1)+getKLevelNodeCount(root.right,k-1);
    }
    // 获取二叉树的高度
    int getHeight(TreeNode root){
        if(root==null) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, int val){

        if(root==null) return null;
        if(root.val==val) return root;
        TreeNode left = find(root.left,val);
        if(left!=null){
            return left;
        }
        TreeNode right = find(root.right,val);
        if(right!=null){
            return right;
        }
        return null;
    }
    //层序遍历
    void levelOrder(TreeNode root){

    }
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root){
        return true;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //System.out.println(binaryTree.size1(binaryTree.createTree()));
        //System.out.println(binaryTree.getLeafNodeCount1(binaryTree.createTree()));
        //System.out.println(binaryTree.getKLevelNodeCount(binaryTree.createTree(),4));
        //System.out.println(binaryTree.getHeight(binaryTree.createTree()));
        TreeNode root = binaryTree.createTree();
        binaryTree.preorderTraversal(root);
    }

}
