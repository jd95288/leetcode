package easy;

/**
 * 或值至少 K 的最短子数组 I
 * <p>
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * 请你返回 nums 中 最短特别非空 子数组 的长度，如果特别子数组不存在，那么返回 -1 。
 *
 * @author jd95288
 * @date 2025-01-16 22:22
 */
public class MinimumSubarrayLength3095 {

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int or = 0;
                for (int x = j; x <= i; x++) {
                    or |= nums[x];
                }
                if (or >= k) {
                    res = Math.min(res, i - j + 1);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
