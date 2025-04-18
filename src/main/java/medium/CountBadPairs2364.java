package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计坏数对的数目
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一个 坏数对 。
 * 请你返回 nums 中 坏数对 的总数目。
 *
 * @author jd95288
 * @date 2025-04-18 8:52
 */
public class CountBadPairs2364 {

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long res = 0L;
        Map<Integer, Long> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            res += i - cnt.merge(i - nums[i], 1L, Long::sum) + 1;
        }
        return res;
    }
}
