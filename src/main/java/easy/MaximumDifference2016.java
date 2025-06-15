package easy;

/**
 * 增量元素之间的最大差值
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 *
 * @author jd95288
 * @date 2025-06-16 0:17
 */
public class MaximumDifference2016 {

    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            res = Math.max(res, num - min);
        }
        return res == 0 ? -1 : res;
    }
}
