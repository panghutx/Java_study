public class Main {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.init();
        System.out.print("递归版前序遍历 ");
        binaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.print("递归版中序遍历 ");
        binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.print("递归版后序遍历 ");
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("===========================");
        System.out.print("非递归前序遍历 ");
        binaryTree.proOderNonRecursive(root);
        System.out.println();
        System.out.print("非递归中序遍历 ");
        binaryTree.inOderNonRecursive(root);
        System.out.println();
        System.out.print("非递归后序遍历 ");
        binaryTree.postOderNonRecursive(root);
        System.out.println();
    }
}
