package medium;

/**
 * 使二进制数组全部等于 1 的最少操作次数 II
 * <p>
 * 给你一个二进制数组 nums 。
 * 你可以对数组执行以下操作 任意 次（也可以 0 次）：
 * 选择数组中 任意 一个下标 i ，并将从下标 i 开始一直到数组末尾 所有 元素 反转 。
 * 反转 一个元素指的是将它的值从 0 变 1 ，或者从 1 变 0 。
 * 请你返回将 nums 中所有元素变为 1 的 最少 操作次数。
 *
 * @author jd95288
 * @date 2024-10-19 17:30
 */
public class MinOperations3192 {

    public int minOperations(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (((res % 2 ^ nums[i]) == 0)) {
                res++;
            }
        }
        return res;
    }

}
