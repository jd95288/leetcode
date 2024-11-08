package medium;

import utils.TreeNode;

/**
 * 二叉搜索树中第 K 小的元素
 * <p>
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 *
 * @author jd95288
 * @date 2024-11-08 21:06
 */
public class KthSmallest230 {

    int i = 1;
    int res = -1;

    /**
     * 执行通过
     */
    public int kthSmallest(TreeNode root, int k) {
        if (i > k) {
            return res;
        }
        if (root.left != null) {
            kthSmallest(root.left, k);
        }
        if (i++ == k) {
            res = root.val;
        }
        if (root.right != null) {
            kthSmallest(root.right, k);
        }
        return res;
    }

}
