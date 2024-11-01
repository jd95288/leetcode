package easy;

import utils.TreeNode;

/**
 * 二叉搜索树的最小绝对差
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author jd95288
 * @date 2024-11-01 23:32
 */
public class GetMinimumDifference530 {

    public int getMinimumDifference(TreeNode root) {
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        if (root.left != null) {
            leftMin = Math.min(root.val - toRightLeaf(root.left), getMinimumDifference(root.left));
        }
        if (root.right != null) {
            rightMin = Math.min(toLeftLeaf(root.right) - root.val, getMinimumDifference(root.right));
        }
        return Math.min(leftMin, rightMin);
    }

    public int toRightLeaf(TreeNode node) {
        if (node.right != null) {
            return toRightLeaf(node.right);
        }
        return node.val;
    }

    public int toLeftLeaf(TreeNode node) {
        if (node.left != null) {
            return toLeftLeaf(node.left);
        }
        return node.val;
    }

}
