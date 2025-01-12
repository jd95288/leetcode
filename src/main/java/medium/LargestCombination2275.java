package medium;

import java.util.Arrays;

/**
 * 按位与结果大于零的最长组合
 * <p>
 * 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
 * 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
 * 同样，对 nums = [7] 而言，按位与等于 7 。
 * 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。
 * 返回按位与结果大于 0 的 最长 组合的长度。
 *
 * @author jd95288
 * @date 2025-01-12 21:50
 */
public class LargestCombination2275 {

    class Solution {
        public int largestCombination(int[] candidates) {
            int[] cnt = new int[24];
            for (int x : candidates) {
                for (int i = 0; x > 0; i++) {
                    cnt[i] += x & 1;
                    x >>= 1;
                }
            }
            return Arrays.stream(cnt).max().getAsInt();
        }
    }

}
