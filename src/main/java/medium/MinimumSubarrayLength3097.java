package medium;

/**
 * 或值至少为 K 的最短子数组II
 * <p>
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * 请你返回 nums 中 最短特别非空 子数组 的长度，如果特别子数组不存在，那么返回 -1 。
 * <p>
 * 求数组 nums 的最短特别子数组长度，特别子数组的所有元素按位与的结果大于等于 k。
 *
 * @author jd95288
 * @date 2025-01-17 8:40
 */
public class MinimumSubarrayLength3097 {

    public int minimumSubarrayLength_v2(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        int right = 0;
        int n = nums.length;
        int or = 0;
        while (right < n) {
            do {
                or |= nums[right++];
            } while (right < n && or < k);
            if (or >= k) {
                int left = right - 1;
                int tmp = 0;
                while (left >= 0) {
                    tmp |= nums[left--];
                    if (tmp >= k) {
                        left++;
                        break;
                    } else {
                        or = tmp;
                    }
                }
                res = Math.min(res, right - left);
            } else {
                break;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
