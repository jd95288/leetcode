package easy;

/**
 * 有序三元组中的最大值 I
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
 * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
 *
 * @author jd95288
 * @date 2025-04-02 0:54
 */
public class MaximumTripletValue2873 {


    public long maximumTripletValue(int[] nums) {
        long res = 0L;
        int n = nums.length;
        int max = 0;
        long maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i]);
            maxDiff = Math.max(maxDiff, max - nums[i]);
            res = Math.max(res, maxDiff * nums[i + 1]);
        }
        return res;
    }

}
