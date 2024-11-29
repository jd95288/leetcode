package hard;

/**
 * 单调数组对的数目II
 * <p>
 * 有一个长度为 n 正整数数组 nums，可以将其拆成两个数组 arr1 arr2，
 * 使之满足 arr1[i] + arr2[i] == nums[i]。问 有多少种拆分方法使得 arr1 非递减 且 arr2 非递增。
 * <p>
 * 1 <= nums[i] <= 1000
 *
 * @author jd95288
 * @date 2024-11-29 9:39
 */
public class CountOfPairs3251 {

    public static int MOD = 1000000007;

    public int countOfPairs(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[][] dp = new int[n][1001];
        for (int i = 0; i <= nums[0]; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int d = Math.max(nums[i] - nums[i - 1], 0);
            for (int j = d; j <= nums[i]; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j - d] % MOD;
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - d]) % MOD;
                }
            }
        }
        for (int i : dp[n - 1]) {
            res = (res + i) % MOD;
        }
        return res;
    }

}
