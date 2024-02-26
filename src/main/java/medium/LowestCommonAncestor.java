package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @author jd95288
 * @date 2024-02-25 11:50
 */
public class LowestCommonAncestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    //我看网友有的解法是，如果p>q，就交换位置，刚开始不知道啥意思，后来才知道是为了后面比较分叉时用的，其实没有必要

    /** 循环也可以，没啥差别*/
    public TreeNode lowestCommonAncestor_v3(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    /**
     * 还有一个更好的做法是一次遍历同时比较p,q，如果一个大于一个小于当前节点表明分叉了
     * 这个是看了题解之后发现的
     */
    public TreeNode lowestCommonAncestor_v2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor_v2(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor_v2(root.right, p, q);
        } else {
            return root;
        }
    }


    /**
     * ----------------------------------------------------------------------
     */
    public TreeNode lowestCommonAncestor_v1(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = findPath(root, p.val, new Stack<>());
        Stack<TreeNode> qStack = findPath(root, q.val, new Stack<>());
        HashSet<Integer> set = new HashSet<>();
        while (!pStack.empty()){
            set.add(pStack.pop().val);
        }
        TreeNode res = null;
        while (!qStack.empty()){
            res = qStack.pop();
            if (set.contains(res.val)) {
                break;
            }
        }

        // 不能根据大小来判断
//        TreeNode pp = pStack.pop();
//        TreeNode qp = qStack.pop();
//        while (pp.val != qp.val) {
//            if (pp.val  > qp.val) {
//                qp = qStack.pop();
//            } else {
//                pp = pStack.pop();
//            }
//        }
        return res;
    }

    public Stack<TreeNode> findPath(TreeNode subRoot, int value, Stack<TreeNode> stack) {
        stack.push(subRoot);
        if (subRoot.val == value) {
            return stack;
        } else if (subRoot.val > value) {
            return findPath(subRoot.left, value, stack);
        } else {
            return findPath(subRoot.right, value, stack);
        }
    }

    /**
     * ----------------------------------------------------------------------
     * 想要通过数组下标来求解不太可行，因为存在许多空节点，占用空间指数增加
     */
    public final int MAX = 100000;
    public int[] treeValues = new int[MAX];
    public int index = 0;
    public int pi = 0;
    public int qi = 0;

    /**
     * 思路是先找到该节点，然后交替求取小index的父节点，比较，如果不是则继续……
     * 但是它给出的数据结构里面不包含父节点的引用，只能由父到子而不能反过来
     * 因此，我们需要先将值保存到数组中，由于是二叉搜索树，是有序的
     * 然后二分查找p,q的index，然后比较父节点index是否一致即可，不一致继续向上找
     * 这里涉及一个问题，左右孩的父节点id算法是不同的，左孩是奇数index，父index为(child-1)/2
     * 右孩是偶数index，父index为(child-2)/2，注意排除root，index为0。
     * 还应该考虑p，q本身就是父子关系的情况，如果pi > qi，先求小的父index，比较pi，然后再求较小节点的父index再比较
     * 说明里面提到树中的值是唯一的。
     * 这个解法超时了，因为死循环，pi，qi的值求错了，二分查找得到的index不对，因为array不是有序的。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverseSubTree(root, 0, p, q);
        // 一定是存在的
        while (pi != qi) {
            if (pi > qi) {
                pi = getParentIndex(pi);
            } else {
                qi = getParentIndex(qi);
            }
        }
        return findNode(root, treeValues[pi]);
    }

    public int getParentIndex(int ci) {
        if (ci == 0) {
            return 0;
        } else if (ci % 2 == 1) {
            return (int) Math.floor((((double) ci - 1.0) / 2.0));
        } else {
            return (int) Math.floor((((double) ci - 2.0) / 2.0));
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor main = new LowestCommonAncestor();
//        System.out.println(main.getParentIndex(1));
//        main.treeValues = new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9};
//        Arrays.sort(main.treeValues);
//        System.out.println(Arrays.toString(main.treeValues));
//        int pi = Arrays.binarySearch(main.treeValues, 2);
//        int qi = Arrays.binarySearch(main.treeValues, 8);
//        System.out.println(pi);
//        System.out.println(qi);

        TreeNode root = generateTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}, 0, 0);
        System.out.println(main.lowestCommonAncestor_v2(root, new TreeNode(2), new TreeNode(8)).toString());
    }
    public static TreeNode generateTree(Integer[] tree, int index, int level){
        if (tree[index] == null){
            return null;
        }
        TreeNode root = new TreeNode(tree[index]);
        int li = 2 * index + 1;
        int ri = 2 * index + 2;
        if( li < tree.length){
            root.left = generateTree(tree, li, level + 1);
        }
        if( ri < tree.length){
            root.right = generateTree(tree, ri, level + 1);
        }
        return root;
    }

    /** 如果想根据二叉树来构建数组，由于存在空节点，因此虽然node个数可能不多，但是数组的长度可能会指数增长！*/
    @Deprecated
    public void traverseSubTree(TreeNode subRoot, int i, TreeNode p, TreeNode q) {
        treeValues[i] = subRoot.val;
        if (p.val == subRoot.val) {
            pi = i;
        }
        if (q.val == subRoot.val) {
            qi = i;
        }
        if (subRoot.left != null) {
            traverseSubTree(subRoot.left, 2 * i + 1, p, q);
        }
        if (subRoot.right != null) {
            traverseSubTree(subRoot.right, 2 * i + 2, p, q);
        }
    }

    public TreeNode findNode(TreeNode subRoot, int value) {
        if (subRoot.val == value) {
            return subRoot;
        } else if (subRoot.val > value) {
            return findNode(subRoot.left, value);
        } else {
            return findNode(subRoot.right, value);
        }
    }

    /**
     * 中序遍历是有序的，但是就没有树的index关系了
     * 并且如果使用Arrays.binarySearch排序的话也会破坏index关系
     */
    @Deprecated
    public void midTraverseSubTree(TreeNode subRoot) {
        if (subRoot.left != null) {
            midTraverseSubTree(subRoot.left);
        }
        treeValues[index++] = subRoot.val;
        if (subRoot.right != null) {
            midTraverseSubTree(subRoot.right);
        }
    }
}
