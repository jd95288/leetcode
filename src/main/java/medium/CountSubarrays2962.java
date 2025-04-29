package medium;

import java.util.Arrays;

/**
 * 统计最大元素出现至少 K 次的子数组
 * <p>
 * 给你一个整数数组 nums 和一个 正整数 k 。
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 * 子数组是数组中的一个连续元素序列。
 *
 * @author jd95288
 * @date 2025-04-29 8:50
 */
public class CountSubarrays2962 {

    public long countSubarrays(int[] nums, int k) {
        long res = 0L;
        int max = Arrays.stream(nums).max().orElse(1);
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            k -= nums[right] == max ? 1 : 0;
            while (k <= 0){
                k += nums[left++] == max ? 1 : 0;
            }
            res += left;
        }
        return res;
    }
}
