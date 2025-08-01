package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除子数组的最大得分
 * <p>
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 *
 * @author jd95288
 * @date 2025-07-22 8:50
 */
public class MaximumUniqueSubarray1695 {

    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int l = 0;
        int sum = 0;
        int res = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (l < r && set.contains(nums[r])) {
                sum -= nums[l];
                set.remove(nums[l++]);
            }
            set.add(nums[r]);
            res = Math.max(res, sum);
        }
        return res;
    }

}
