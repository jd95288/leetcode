package medium;

import utils.TreeNode;

/**
 * 验证二叉搜索树
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * @author jd95288
 * @date 2024-11-09 12:20
 */
public class IsValidBST98 {

    boolean res = true;
    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (!res || root == null) {
            return;
        }
        dfs(root.left);
        if (prev >= root.val) {
            res = false;
        } else {
            prev = root.val;
        }
        dfs(root.right);
    }

}
