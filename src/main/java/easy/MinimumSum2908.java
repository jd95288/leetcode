package easy;


/**
 * 元素和最小的山形三元组 I
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
 * i < j < k
 * nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
 *
 * @author jd95288
 * @date 2024-03-29 0:52
 */
public class MinimumSum2908 {
    public int minimumSum(int[] nums) {
        int[] lmin = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            lmin[i] = min = Math.min(min, nums[i - 1]);
        }
        int res = Integer.MAX_VALUE;
        int rmin = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; i--) {
            rmin = Math.min(rmin, nums[i + 1]);
            if (lmin[i] < nums[i] && rmin < nums[i]) {
                res = Math.min(res, lmin[i] + rmin + nums[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
