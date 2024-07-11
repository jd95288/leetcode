package easy;

/**
 * 统计移除递增子数组的数目 I
 * <p>
 * 给你一个下标从 0 开始的 正 整数数组 nums 。
 * 如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。
 * 比方说，[5, 3, 4, 6, 7] 中的 [3, 4] 是一个移除递增子数组，
 * 因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。
 * 请你返回 nums 中 移除递增 子数组的总数目。
 * 注意 ，剩余元素为空的数组也视为是递增的。
 * 子数组 指的是一个数组中一段连续的元素序列。
 *
 * @author jd95288
 * @date 2024-07-10 1:27
 */
public class IncremovableSubarrayCount2970 {

    /**
     * 暴力求解
     */
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            here:
            for (int j = i; j < n; j++) {
                int last = -1;
                for (int k = 0; k < n; k++) {
                    if ((k < i || k > j) && nums[k] > last) {
                        last = nums[k];
                    } else if (k < i || k > j) {
                        continue here;
                    }
                }
                res++;
            }
        }

        return res;
    }

}
