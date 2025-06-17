package medium;

import java.util.Arrays;

/**
 * 划分数组并满足最大差限制
 * <p>
 * 给你一个长度为 n 的整数数组 nums，以及一个正整数 k 。
 * 将这个数组划分为 n / 3 个长度为 3 的子数组，并满足以下条件：
 * 子数组中 任意 两个元素的差必须 小于或等于 k 。
 * 返回一个 二维数组 ，包含所有的子数组。如果不可能满足条件，就返回一个空数组。如果有多个答案，返回 任意一个 即可。
 *
 * @author jd95288
 * @date 2025-06-18 0:08
 */
public class DivideArray2966 {

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] res = new int[n / 3][3];
        for (int i = 1; i < n - 1; i += 3) {
            int cur = nums[i];
            int prev = nums[i - 1];
            int next = nums[i + 1];
            if (next - prev > k) {
                return new int[][]{};
            }
            res[i / 3] = new int[]{prev, cur, next};
        }
        return res;
    }

}
