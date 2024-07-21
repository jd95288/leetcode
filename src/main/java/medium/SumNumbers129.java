package medium;

import utils.TreeNode;

/**
 * 求根节点到叶节点数字之和
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 *
 * @author jd95288
 * @date 2024-07-21 1:45
 */
public class SumNumbers129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prefix) {
        if (root == null) {
            return 0;
        }
        prefix = prefix * 10 + root.val;
        int res = 0;
        res += dfs(root.left, prefix);
        res += dfs(root.right, prefix);
        return res == 0 ? prefix : res;
    }
}
