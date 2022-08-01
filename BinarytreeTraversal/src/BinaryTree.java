import java.util.Stack;

public class BinaryTree {

    /**
     * 穷举法创建一个二叉树
     * 创建一个八结点的二叉树，各结点分别为ABCDEFGH
     * A是根节点
     * @return TreeNode
     */
    public TreeNode init(){

        //穷举法创建二叉树,返回根节点
        TreeNode nodeA = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        TreeNode nodeG = new TreeNode('G');
        TreeNode nodeH = new TreeNode('H');
        nodeA.left=nodeB;
        nodeB.left=nodeD;
        nodeC.left=nodeF;
        nodeB.right=nodeE;
        nodeD.left=nodeH;
        nodeA.right=nodeC;
        nodeC.right=nodeG;
        return nodeA;
    }

    /**
     * 递归版本的前序遍历  根->左->右
     * 若二叉树为空，返回
     * 若二叉树不为空，先访问根节点，然后前序遍历左子树，再前序遍历右子树
     * @param root
     */
    public void preOrderTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        System.out.print(root.val+" "); //打印结点val值
        preOrderTraversal(root.left); //前序遍历左子树
        preOrderTraversal(root.right); //前序遍历右子树
    }

    /**递归版本的中序遍历 左->根->右
     * 若二叉树为空，返回
     * 若二叉树不为空，先中序遍历左子树，然后访问根节点，再中序遍历右子树
     * @param root
     */
    public void inOrderTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }

    /**
     * 递归版本的后序遍历 左->右->根
     * 若二叉树为空，返回
     * 若二叉树不为空，先后序遍历左子树，再后序遍历右子树，最后访问根节点
     * @param root
     */
    public void postOrderTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

//    //非递归前序遍历(版本1）
//    public void proOderNonRecursive(TreeNode root){
//        Stack<TreeNode> stack = new Stack<>();
//        while(root!=null || !stack.isEmpty())
//        {
//            while(root!=null)
//            {
//                System.out.print(root.val+" ");;
//                stack.push(root);
//                root = root.left;
//            }
//            if(!stack.isEmpty())
//            {
//                root=stack.pop();
//                root=root.right;
//            }
//        }
//
//    }

    /**
     * 非递归前序遍历
     * 若二叉树为空，返回
     * 创建一个Stack用来存放节点，将根节点入栈
     * 当栈不为空，弹出栈顶元素并打印，之后再打印栈顶元素（node)结点的左子树和右子树。
     * 因为栈是先入后出，所以入栈顺序是右子树、左子树
     * @param root
     */
    public void proOderNonRecursive(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }

    /**
     * 非递归中序遍历
     * 创建一个Stack用来存放节点
     * 当根节点不为空或栈不为空，执行以下操作
     * 当根节点不为空，入栈，根节点指向其左子树
     * 如果栈不为空，弹出栈顶元素并打印，根节点指向其右子树
     * @param root
     */
    public void inOderNonRecursive(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty())
        {
            while(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty())
            {
                root=stack.pop();
                System.out.print(root.val+" ");
                root=root.right;
            }
        }
    }
    /**
     * 非递归后序遍历
     * 后序结点的访问顺序是左->右->根    与前序遍历类似
     * 若二叉树为空，返回
     * 创建一个Stack用来存放节点，将根节点入栈
     * 当栈不为空，弹出栈顶元素并打印，将弹出元素入栈stack2
     * 之后再打印栈顶元素（node)结点的右子树和左子树，入栈顺序是左子树、右子树。
     * 这样访问顺序就是根 右 左
     * 将结果倒过来就是 左->右->根，也就是依次弹出stack2的元素
     * @param root
     */
    public void postOderNonRecursive(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack1= new Stack<>();
        Stack<TreeNode> stack2= new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push((node.right));
            }
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().val+" ");
        }
    }

}
