package hard;

import utils.ArrayFromFile;

/**
 * 找到按位或最接近 K 的子数组
 * <p>
 * 给你一个数组 nums 和一个整数 k 。你需要找到 nums 的一个 子数组，
 * 满足子数组中所有元素按位或运算 OR 的值与 k 的 绝对差 尽可能 小 。
 * 换言之，你需要选择一个子数组 nums[l..r] 满足 |k - (nums[l] OR nums[l + 1] ... OR nums[r])| 最小。
 * 请你返回 最小 的绝对差值。子数组 是数组中连续的 非空 元素序列。
 *
 * @author jd95288
 * @date 2024-10-09 8:59
 */
public class MinimumDifference3171 {

    public int minimumDifference_v1(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int right = nums[i];
            for (int j = i - 1; j >= 0 && ((nums[j] | right) != nums[j]); j--) {
                nums[j] |= right;
                res = Math.min(res, Math.abs(nums[j] - k));
            }
            res = Math.min(res, Math.abs(right - k));
        }
        return res;
    }

}
