package hard;

/**
 * 统计得分小于 K 的子数组数目
 * <p>
 * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
 * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
 * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
 * 子数组 是数组中的一个连续元素序列。
 *
 * @author jd95288
 * @date 2025-04-28 8:41
 */
public class CountSubarrays2302 {

    public long countSubarrays(int[] nums, long k) {
        long res = 0L;
        int n = nums.length;
        int left = 0;
        long sum = 0L;
        int len = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            len++;
            while (left < n && sum * len >= k) {
                sum -= nums[left++];
                len--;
            }
            // 可以直接用 res += len
            res += right - left + 1;
        }
        return res;
    }

}
