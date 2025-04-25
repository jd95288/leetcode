package medium;

import java.util.List;

/**
 * 统计趣味子数组的数目
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums ，以及整数 modulo 和整数 k 。
 * 请你找出并统计数组中 趣味子数组 的数目。
 * 如果 子数组 nums[l..r] 满足下述条件，则称其为 趣味子数组 ：
 * 在范围 [l, r] 内，设 cnt 为满足 nums[i] % modulo == k 的索引 i 的数量。并且 cnt % modulo == k 。
 * 以整数形式表示并返回趣味子数组的数目。
 * 注意：子数组是数组中的一个连续非空的元素序列。
 *
 * @author jd95288
 * @date 2025-04-25 0:35
 */
public class CountInterestingSubarrays2845 {

    public long countInterestingSubarrays_v1(List<Integer> nums, int modulo, int k) {
        long res = 0L;
        int n = nums.size();
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (nums.get(i - 1) % modulo == k ? 1 : 0);
        }
        long[] cnt = new long[Math.min(modulo, n + 1)];
        cnt[0] = 1;
        for (int right = 0; right < n; right++) {
            if (prefix[right + 1] - k >= 0) {
                res += cnt[(prefix[right + 1] - k) % modulo];
            }
            cnt[prefix[right + 1] % modulo]++;
        }
        return res;
    }
}
