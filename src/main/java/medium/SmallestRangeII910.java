package medium;

import java.util.Arrays;

/**
 * 最小差值II
 * <p>
 * 给你一个整数数组 nums，和一个整数 k 。
 * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
 * nums 的 分数 是 nums 中最大元素和最小元素的差值。
 * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
 *
 * @author jd95288
 * @date 2024-10-21 9:57
 */
public class SmallestRangeII910 {

    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[n - 1] - nums[0];
        for (int i = 1; i < n; i++) {
            int max = Math.max(nums[i - 1] + k, nums[n - 1] - k);
            int min = Math.min(nums[0] + k, nums[i] - k);
            res = Math.min(res, max - min);
        }
        return res;
    }

}
