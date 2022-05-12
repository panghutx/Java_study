
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
      //创建一个二叉树
          TreeNode creat(){TreeNode A =new TreeNode(1);
              TreeNode B =new TreeNode(2);
              TreeNode C =new TreeNode(3);
              TreeNode D =new TreeNode(4);
              TreeNode E =new TreeNode(5);
                A.left=B;
                A.right=C;
                B.left=D;
                B.right=E;
                return A;
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

          //二叉树叶子节点(遍历思路）

          int leafPoint(TreeNode root){
              if(root==null){
                  return 0;
              }
              if(root.left==null && root.right==null){
                  count++;
              }
              leafPoint(root.left);
              leafPoint(root.right);
              return count;
          }

          //二叉树叶子节点（子问题思路）
          int leafPoint1(TreeNode root){
              if(root==null){
                  return 0;
              }
              if(root.left!=null && root.right!=null){
                  return 1;
              }else {
                  return leafPoint1(root.left)+leafPoint1(root.right);
              }
          }

          /**
           * 求k层节点个数
           */
          int levelNode(TreeNode root,int k){
              if(root==null){
                  return 0;
              }
              if(k==1){
                  return 1;
              }
              return levelNode(root.left,k-1) + levelNode(root.right,k-1);
          }

          /**
           * 获取二叉树的高度
           */
          int getHeight(TreeNode root){
              if(root==null){
                  return 0;
              }
              return Math.max(getHeight(root.left),getHeight(root.right))+1;
          }

          /**
           * 找二叉树中的指定节点
           */
          TreeNode find (TreeNode root,int val){
              if(root==null){
                  return null;
              }
              if(root.val==val){
                  return root;
              }
              TreeNode rst = find(root.left,val);
              if(rst!=null){
                  return rst;
              }
              rst = find(root.right,val);
              return rst;

          }

          /**
           * 判断一个二叉树是否为完全二叉树
           */

          boolean isComplete(TreeNode root){
              if(root==null){
                  return true;
              }
              Queue<TreeNode> list = new LinkedList<>();
              list.add(root);
              while(!list.isEmpty()){
                  TreeNode cur = list.poll();
                  if(cur!=null){
                      list.offer(cur.left);
                      list.add(cur.right);
                  }else {
                      break;
                  }
              }
              while(!list.isEmpty()){
                  if(list.poll()!=null){
                      return false;
                  }
              }
              return true;




          }

          public void main(String[] args) {
              TreeNode treeNode = new TreeNode();
              TreeNode root = treeNode.creat();
              System.out.println(treeNode.find(root, 3));

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
