package medium;


/**
 * 最大或值
 * <p>
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k 。每一次操作中，你可以选择一个数并将它乘 2 。
 * 你最多可以进行 k 次操作，请你返回 nums[0] | nums[1] | ... | nums[n - 1] 的最大值。
 * a | b 表示两个整数 a 和 b 的 按位或 运算。
 *
 * @author jd95288
 * @date 2025-03-21 0:08
 */
public class MaximumOr2680 {

    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int or = 0;
        int fix = 0;
        for (int i = 0; i < n; i++) {
            fix = fix | or & nums[i];
            or = or | nums[i];
        }
        long res = 0L;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, or ^ nums[i] | fix | ((long) nums[i] << k));
        }
        return res;
    }

}
