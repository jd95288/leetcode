package medium;

/**
 * 找出有效子序列的最大长度II
 * <p>
 * 给你一个整数数组 nums 和一个 正 整数 k 。
 * nums 的一个 子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列 ：
 * (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k
 * 返回 nums 的 最长有效子序列 的长度。
 *
 * @author jd95288
 * @date 2025-07-16 10:18
 */
public class MaximumLength3202 {

    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            int m = num % k;
            for (int i = 0; i < k; i++) {
                dp[i][m] = dp[m][i] + 1;
                res = Math.max(res, dp[i][m]);
            }
        }
        return res;
    }

}
