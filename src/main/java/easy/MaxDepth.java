package easy;

import utils.TreeNode;

/**
 * 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * @author jd95288
 * @date 2024-03-16 22:23
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int depth) {
        int leftDepth = depth;
        int rightDepth = depth;
        if (root.left != null) {
            leftDepth = dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            rightDepth = dfs(root.right, depth + 1);
        }
        return Math.max(leftDepth, rightDepth);
    }
}
