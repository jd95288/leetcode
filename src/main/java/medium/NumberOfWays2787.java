package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个数字表示成幂的和的方案数
 * <p>
 * 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。
 * 换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满足 n = n1^x + n2^x + ... + nk^x 。
 * 由于答案可能非常大，请你将它对 10^9 + 7 取余后返回。
 * 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 2^3 + 3^3 + 5^3 。
 *
 * @author jd95288
 * @date 2025-08-12 9:08
 */
public class NumberOfWays2787 {

    public int numberOfWays(int n, int x) {
        int mod = 1000000007;
        int max = (int) Math.ceil(Math.pow(n, 1.0 / x));
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= max; i++) {
            int pow = (int) Math.pow(i, x);
            for (int j = n; j >= pow; j--) {
                dp[j] += dp[j - pow];
            }
        }
        return (int)(dp[n] % mod);
    }

}
