package easy;

/**
 * 统计符合条件长度为 3 的子数组数目
 * <p>
 * 给你一个整数数组 nums ，请你返回长度为 3 的 子数组，满足第一个数和第三个数的和恰好为第二个数的一半。
 * 子数组 指的是一个数组中连续 非空 的元素序列。
 *
 * @author jd95288
 * @date 2025-04-27 0:14
 */
public class CountSubarrays3392 {

    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0;
        int res = 0;
        for (int right = 2; right < n; right++) {
            if ((nums[left++] + nums[right]) * 2 == nums[right - 1]) {
                res++;
            }
        }
        return res;
    }

}
