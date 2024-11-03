package easy;

import utils.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 *
 * @author jd95288
 * @date 2024-11-03 18:32
 */
public class SortedArrayToBST108 {

    public TreeNode sortedArrayToBST_v1(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int m = (left + right) >>> 1;
        return new TreeNode(nums[m], dfs(nums, left, m - 1), dfs(nums, m + 1, right));
    }

}
