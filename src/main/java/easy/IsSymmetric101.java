package easy;

import utils.TreeNode;

/**
 * 对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author jd95288
 * @date 2024-10-26 23:18
 */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode left, TreeNode right) {
        if ((left == null && right != null)
                || (left != null && right == null)) {
            return false;
        } else if (left == null) {
            return true;
        } else {
            return right.val == left.val
                    && isEqual(left.left, right.right)
                    && isEqual(left.right, right.left);
        }
    }

}
