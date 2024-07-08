package medium;

/**
 * 交替子数组计数
 * <p>
 * 给你一个 二进制数组 nums 。
 * 如果一个子数组中不存在两个相邻元素的值相同的情况，我们称这样的子数组为 交替子数组 。
 * 返回数组 nums 中交替子数组的数量。
 *
 * @author jd95288
 * @date 2024-07-06 20:52
 */
public class CountAlternatingSubarrays3101 {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long res = 0;
        int s = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                int k = i - s;
                res += k * (k + 1) / 2;
                s = i;
            }
        }
        if (s != n - 1) {
            int k = n - s;
            res += k * (k + 1L) / 2;
        } else {
            res++;
        }
        return res;
    }
}
