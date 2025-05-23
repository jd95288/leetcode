package medium;

/**
 * 分割数组的方案数
 * <p>
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
 * 如果以下描述为真，那么 nums 在下标 i 处有一个 合法的分割 ：
 * 前 i + 1 个元素的和 大于等于 剩下的 n - i - 1 个元素的和。
 * 下标 i 的右边 至少有一个 元素，也就是说下标 i 满足 0 <= i < n - 1 。
 * 请你返回 nums 中的 合法分割 方案数。
 *
 * @author jd95288
 * @date 2025-01-13 8:41
 */
public class WaysToSplitArray2270 {

    public int waysToSplitArray_v1(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int res = 0;
        long tmp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            tmp += nums[i];
            if (2 * tmp >= sum) {
                res++;
            }
        }
        return res;
    }

}
