package medium;

/**
 * 多米诺和托米诺平铺
 * <p>
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10^9 + 7 取模 的值。
 * 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。
 *
 * @author jd95288
 * @date 2025-05-05 21:37
 */
public class NumTilings790 {

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((2 * dp[i - 1]) % mod + dp[i - 3]) % mod;
        }
        return dp[n];
    }

}
