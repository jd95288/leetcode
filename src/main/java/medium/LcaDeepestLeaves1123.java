package medium;

import utils.TreeNode;

/**
 * 最深叶节点的最近公共祖先
 * <p>
 * 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 * 回想一下：
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *
 * @author jd95288
 * @date 2025-04-04 19:09
 */
public class LcaDeepestLeaves1123 {


    TreeNode res;
    int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, -1);
        return res;
    }

    public int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        int leftDepth = dfs(node.left, depth + 1);
        int rightDepth = dfs(node.right, depth + 1);
        int d = Math.max(leftDepth, rightDepth);
        maxDepth = Math.max(maxDepth, d);
        if (rightDepth == maxDepth && leftDepth == maxDepth) {
            res = node;
        }
        return d;
    }
}
