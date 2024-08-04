package easy;

import utils.TreeNode;

/**
 * 另一棵树的子树
 * <p>
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 * 如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 * @author jd95288
 * @date 2024-08-04 15:36
 */
public class IsSubtree572 {

    /**
     * 网友题解
     * 参考写法
     */
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                return false;
            }
            return isSameTree(root, subRoot) ||
                    isSubtree(root.left, subRoot) ||
                    isSubtree(root.right, subRoot);
        }

        // 100. 相同的树
        private boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) {
                return p == q; // 必须都是 null
            }
            return p.val == q.val &&
                    isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right);
        }
    }


    /**
     * 执行通过
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (compare(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean compare(TreeNode root, TreeNode subRoot) {
        if (root.val != subRoot.val) {
            return false;
        }
        boolean res = false;
        if (root.left != null && subRoot.left != null) {
            res = compare(root.left, subRoot.left);
        } else if (root.left == null && subRoot.left == null){
            res = true;
        }
        if (root.right != null && subRoot.right != null) {
            res = compare(root.right, subRoot.right) && res;
        } else if (root.right == null && subRoot.right == null) {
        } else {
            res = false;
        }
        return res;
    }

}
