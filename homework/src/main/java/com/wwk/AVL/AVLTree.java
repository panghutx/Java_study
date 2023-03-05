package com.wwk.AVL;

/**
 * @Description: AVL树类
 * @Author: Administrator
 * @Version:
 */

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> mRoot; //结点
    private long lookTime = 0L; //数据查找次数
    //AVL树的结点(内部类)
    public class AVLNode<T extends Comparable<T>> {
        T key;  //结点的值
        int height; //高度
        AVLNode<T> left; //左孩子
        AVLNode<T> right; //右孩子

        public AVLNode(T key, AVLNode<T> left, AVLNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    //构造函数
    public AVLTree() {
        mRoot = null;
    }

    //获取树的高度
    private int height(AVLNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }
        return 0;
    }

    public int getHeight() {
        return height(mRoot);
    }

    //找两个树的最大值
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    //前序遍历
    private void preOrder(AVLNode<T> tree) {
        if (tree != null) {
            System.out.print("[" + tree.key + "]   ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void proOrder() {
        preOrder(mRoot);
    }

    //中序遍历
    private void inOrder(AVLNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print("[" + tree.key + "]   ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    //后序遍历
    private void postOrder(AVLNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print("[" + tree.key + "]   ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /*
     * @desc: 查找"AVL树中结点x"的键值为key的结点(递归实现)
     * @param x：结点
     * @param key: 查找的值
     * @return: avl.AVLTree<T>.AVLNode<T>
     */
    private AVLNode<T> search(AVLNode<T> x, T key) {
        lookTime++;
        if (x == null) {
            return x;
        }
        int cmp = key.compareTo(x.key); //比较
        if (cmp < 0) { //如果key比x的key小，在x的左子树中找
            return search(x.left, key);
        } else if (cmp > 0) {//如果key比x的key大，在x的右子树中找
            return search(x.right, key);
        } else {
            return x;
        }
    }

    public AVLNode<T> search(T key) {
        return search(mRoot, key);
    }

    /*
     * @desc: 查找"AVL树中结点x"的键值为key的结点(递归实现)
     * @param x: 结点
     * @param key: 待查找的值
     * @return: avl.AVLTree<T>.AVLNode<T>
     */
    private AVLNode<T> iterativeSearch(AVLNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return x;
    }

    public AVLNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /*
     * @desc: 查找最小结点：返回tree为根结点的AVL树的最小结点
     * @param tree: AVL树
     * @return: avl.AVLTree<T>.AVLNode<T>
     */
    private AVLNode<T> minNum(AVLNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.left != null) { //在tree的左子树中查找
            tree = tree.left;
        }
        return tree;
    }

    public T minNum() {
        AVLNode<T> p = minNum(mRoot);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    /*
     * @desc: 查找最大结点：返回tree为根结点的AVL树的最大结点
     * @param tree:
     * @return: avl.AVLTree<T>.AVLNode<T>
     */
    private AVLNode<T> maxNum(AVLNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.right != null) { //在tree的右子树中查找
            tree = tree.right;
        }
        return tree;
    }

    public T maxNum() {
        AVLNode<T> p = maxNum(mRoot);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    public long getLookTime() {
        return lookTime;
    }

    /*
     * @desc: LL,左左对应的情况(左单旋转)
     * @param k2: 结点
     * @return: avl.AVLTree<T>.AVLNode<T>  返回旋转后的根结点
     */
    private AVLNode<T> leftLeftRotate(AVLNode<T> k2) {
        AVLNode<T> k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;

        return k1;
    }

    /*
     * @desc: RR,右右对应的情况(右单旋转)
     * @param k1: 结点
     * @return: avl.AVLTree<T>.AVLNode<T> 旋转后的根结点
     */
    private AVLNode<T> rightRightRotate(AVLNode<T> k1) {
        AVLNode<T> k2;
        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;

        return k2;
    }

    /*
     * @desc: LR,左右对应的情况(左双旋转)
     * @param k3: 结点
     * @return: avl.AVLTree<T>.AVLNode<T> 旋转后的根结点
     */
    private AVLNode<T> leftRightRotate(AVLNode<T> k3) {
        k3.left = rightRightRotate(k3.left);

        return leftLeftRotate(k3);
    }

    /*
     * @desc: RL,右左对应的情况(右双旋转)
     * @param k1: 结点
     * @return: avl.AVLTree<T>.AVLNode<T> 旋转后的根结点
     */
    private AVLNode<T> rightLeftRotate(AVLNode<T> k1) {
        k1.right = leftLeftRotate(k1.right);

        return rightRightRotate(k1);
    }

    /*
     * @desc: 将结点插入到AVL树中，并返回根结点
     * @param tree：AVL树的根结点
     * @param key: 插入的结点的键值
     * @return: avl.AVLTree<T>.AVLNode<T> 返回根结点
     */
    private AVLNode<T> insert(AVLNode<T> tree, T key) {
        if (tree == null) { //如果树为空,新建结点
            tree = new AVLNode<T>(key, null, null);
            if (tree == null) {
                System.out.println("Error：create avltree node failed!");
                return null;
            }
        } else {
            int cmp = key.compareTo(tree.key);
            if (cmp < 0) { //若key小于根结点,则插入到左子树
                tree.left = insert(tree.left, key);
                //插入结点后,若AVL树失去平衡,则进行相应的调节
                if (height(tree.left) - height(tree.right) == 2) {
                    if (key.compareTo(tree.left.key) < 0) {
                        tree = leftLeftRotate(tree);
                    } else {
                        tree = leftRightRotate(tree);
                    }
                }
            } else if (cmp > 0) { //若key大于根结点,则插入到右子树
                tree.right = insert(tree.right, key);
                //插入结点后，若AVL树失去平衡，则进行相应的调节
                if (height(tree.right) - height(tree.left) == 2) {
                    if (key.compareTo(tree.right.key) > 0) {
                        tree = rightRightRotate(tree);
                    } else {
                        tree = rightLeftRotate(tree);
                    }
                }
            } else { //cmp ==0
                System.out.println("添加失败：不允许添加相同的结点!");
            }
        }
        tree.height = max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    /*
     * @desc: 删除结点
     * @param tree：AVL树的根结点
     * @param z: 待删除结点
     * @return: avl.AVLTree<T>.AVLNode<T> 返回根结点
     */
    private AVLNode<T> remove(AVLNode<T> tree, AVLNode<T> z) {
        //根为空 或者 没有要删除的结点,直接返回null
        if (tree == null || z == null) {
            return null;
        }
        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) {  //待删除结点在tree的左子树中
            tree.left = remove(tree.left, z);

            //删除结点后，若AVL树失去平衡,则进行相应的调节
            if (height(tree.right) - height(tree.left) == 2) {
                AVLNode<T> r = tree.right;
                if (height(r.left) > height(r.right)) {
                    tree = rightLeftRotate(tree);
                } else {
                    tree = rightRightRotate(tree);
                }
            }
        } else if (cmp > 0) { //待删除结点在tree的右子树中
            tree.right = remove(tree.right, z);
            //删除结点后，若AVL树失去平衡,则进行相应的调节
            if (height(tree.left) - height(tree.right) == 2) {
                AVLNode<T> l = tree.left;
                if (height(l.right) > height(l.left)) {
                    tree = leftRightRotate(tree);
                } else {
                    tree = leftLeftRotate(tree);
                }
            }
        } else { //tree是对应要删除的结点
            if ((tree.left != null) && (tree.right != null)) { //tree的左右孩子都非空
                if (height(tree.left) > height(tree.right)) {
                    /*如果tree的左子树比右子树高,则：
                       (1)找出tree的左子树中的最大结点
                       (2)将该最大结点的值赋给tree
                       (3)删除该最大结点
                       这类似于用"tree"的左子树中最大结点做"tree"的替身
                       好处：删除"tree"的左子树中最大结点后,AVL树仍然是平衡的
                     */
                    AVLNode<T> max = minNum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    /*
                       如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高),则
                         (1)找到tree的右子树中的最小结点
                         (2)将该最小结点的值赋给tree
                         (3)删除该最小结点
                        这类似于用"tree"的右子树中最小结点做"tree"的替身;
                        好处：删除"tree的右子树中最小结点"后,AVL树仍然是平衡的
                    */
                    AVLNode<T> min = minNum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            } else {
                AVLNode<T> tmp = tree;
                tree = (tree.left != null) ? tree.left : tree.right;
                tmp = null;
            }
        }
        return tree;
    }

    public void remove(T key) {
        AVLNode<T> z = search(mRoot, key);
        if (z != null) {
            mRoot = remove(mRoot, z);
        }
    }

    /*
     * @desc: 销毁AVL树
     * @param tree: AVL树
     * @return: void
     */
    private void destroy(AVLNode<T> tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            destroy(tree.left);
        }
        if (tree.right != null) {
            destroy(tree.right);
        }
        tree = null;
    }

    public void destroy() {
        destroy(mRoot);
    }

    /*
     * @desc: 打印AVL树
     * @param tree：AVL树
     * @param key：结点的键值
     * @param direction:
     *      -- 0 ：表示该结点是根结点
     *      -- -1：表示该结点时它的父结点的左孩子
     *      -- 1：表示该结点时它的父结点的右孩子
     * @return: void
     */
    private void print(AVLNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0) { //tree是根结点
                System.out.printf("%2d is root\n", tree.key, key);
            } else { //tree的分支结点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");
            }
            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }
}
