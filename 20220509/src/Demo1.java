
import java.util.ArrayList;
import java.util.List;

public class Demo1 {

      class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
      }
      //二叉树的节点个数（遍历思路）
          int count=0;
          int pointCount(TreeNode root){

                if(root==null){
                    return 0;
                }else {
                    count++;
                }
                pointCount(root.left);
                pointCount(root.right);
                return count;
      }
      //二叉树节点个数（子问题思路）
          int pointCount1(TreeNode root){
              if(root==null){
                  return 0;
              }
              return pointCount1(root.left)+pointCount1(root.right)+1;

          }


  }
     //层序遍历
     class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            return helper(root, 0);
        }

        public List<List<Integer>> helper(TreeNode root, int n) {//n表示树的第几层（从0开始）
            if (root == null) return res;//终止条件
            if (n > res.size() - 1) {
                List<Integer> tempList = new ArrayList<>();//若res中不存在下标为n的List,则new一个tempList
                tempList.add(root.val);//把该节点的值加入tempList中
                res.add(tempList);//把tempList加入res中
            } else {
                res.get(n).add(root.val);//若res中存在下标为n的List,则把该节点的值加入res的第n个元素中
            }
            if (root.left != null) helper(root.left, n + 1);//递归左子树
            if (root.right != null) helper(root.right, n + 1);//递归右子树
            return res;
        }
    }


}
