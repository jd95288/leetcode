package medium;

/**
 * 骑士拨号器
 *
 * @author jd95288
 * @date 2024-12-10 9:39
 */
public class KnightDialer935 {

    public int knightDialer(int n) {
        long[][] dp = new long[n + 1][10];
        dp[1] = new long[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int MOD = 1000000007;
        int res = 0;
        for (int k = 2; k <= n; k++) {
            dp[k][0] = (dp[k - 1][4] + dp[k - 1][6]) % MOD;
            dp[k][1] = (dp[k - 1][6] + dp[k - 1][8]) % MOD;
            dp[k][2] = (dp[k - 1][7] + dp[k - 1][9]) % MOD;
            dp[k][3] = (dp[k - 1][4] + dp[k - 1][8]) % MOD;
            dp[k][4] = (dp[k - 1][3] + dp[k - 1][9] + dp[k - 1][0]) % MOD;
            dp[k][6] = (dp[k - 1][1] + dp[k - 1][7] + dp[k - 1][0]) % MOD;
            dp[k][7] = (dp[k - 1][2] + dp[k - 1][6]) % MOD;
            dp[k][8] = (dp[k - 1][1] + dp[k - 1][3]) % MOD;
            dp[k][9] = (dp[k - 1][2] + dp[k - 1][4]) % MOD;
        }
        for (int i = 0; i < 10; i++) {
            res = (int) (res + dp[n][i]) % MOD;
        }
        return res;
    }

}
