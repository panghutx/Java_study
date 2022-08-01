public class BinarySearchTree {
    static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private TreeNode root;

    /**
     * 插入一个结点
     * @param key 要插入的节点
     * @return boolean
     */
    public boolean insert(int key){
        TreeNode node = new TreeNode(key);
        if(root==null){
            root=node;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.val<key){
                pre = cur;
                cur=cur.right;
            }else if(cur.val>key){
                pre = cur;
                cur=cur.left;
            }else {
                return false;
            }
        }
        if(pre.val<key){
            pre.right=node;
        }else {
            pre.left=node;
        }
        return true;
    }

    /**
     *
     * @param key 要查找的节点
     * @return TreeNode
     */
    public TreeNode search(int key){
        if(root==null){
            return null;
        }
        TreeNode cur = root;
        while(cur!=null){
            if(cur.val<key){
                cur=cur.right;
            }else if(cur.val>key){
                cur=cur.left;
            }else {
                return cur;
            }
        }
        return null;
    }

    /**
     *
     * @param key 要删除的节点
     * @return
     */
    public void remove(int key){
        if(root==null){
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.val<key){
                pre=cur;
                cur=cur.right;
            }else if(cur.val>key){
                pre=cur;
                cur=cur.left;
            }else {
                //执行删除操作
                removeKey(cur,pre);
                return;
            }
        }
    }

    private void removeKey(TreeNode cur,TreeNode pre) {
        //1.左叶子为空
        if(cur.left==null){
            //1.1 cur是根节点
            if(cur==root){
                root=root.right;
            }else if(cur==pre.left){
                //1.2 cur是parent的left
                pre.left=cur.right;
            }else {
                //1.3 cur是parent的right
                pre.right=cur.right;
                //cur = cur.right; //这样是错误的
            }
            //2.右叶子为空
        } else if(cur.right==null){
            //2.1 cur是根节点
            if(cur==root){
                root = root.left;
            }else if(cur==pre.left){
                //2.2 cur是parent的left
                pre.left=cur.left;
            }else if(cur==pre.right){
                //2.3 cur是parent的right
                pre.right=cur.left;
            }
            //3.左右叶子都不为空
        }else {
            //在cur的右子树找最小值，找到后这个最小值的结点左树一定是空的
            TreeNode parentTarget = cur;
            TreeNode target = cur.right;
            while(target.left!=null){
                parentTarget=target;
                target=target.left;
            }
            cur.val=target.val;
            //分两种情况
            //3.1 tp的左子树是target
            if(parentTarget.left==target){
                parentTarget.left=target.right;
            }else {
                //3.2 tp的右子树是target
                parentTarget.right=target.right;
            }

        }

    }
}
