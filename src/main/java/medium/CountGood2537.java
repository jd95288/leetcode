package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计好子数组的数目
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 * 子数组 是原数组中一段连续 非空 的元素序列。
 *
 * @author jd95288
 * @date 2025-04-16 8:39
 */
public class CountGood2537 {

    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0;
        int pairCnt = 0;
        for (int r = 0; r < n; r++) {
            pairCnt += cnt.getOrDefault(nums[r], 0);
            cnt.merge(nums[r], 1, Integer::sum);
            while (pairCnt >= k){
                res += n - r;
                cnt.merge(nums[l], -1, Integer::sum);
                pairCnt -= cnt.get(nums[l++]);
            }
        }
        return res;
    }

}
