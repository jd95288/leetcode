package easy;

/**
 * 循环数组中相邻元素的最大差值
 * <p>
 * 给你一个 循环 数组 nums ，请你找出相邻元素之间的 最大 绝对差值。
 * 注意：一个循环数组中，第一个元素和最后一个元素是相邻的。
 *
 * @author jd95288
 * @date 2025-06-12 0:02
 */
public class MaxAdjacentDistance3423 {

    public int maxAdjacentDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, Math.abs(nums[i % n] - nums[i - 1]));
        }
        return res;
    }
}
