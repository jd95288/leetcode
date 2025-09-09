package medium;


/**
 * 知道秘密的人数
 * <p>
 * 在第 1 天，有一个人发现了一个秘密。
 * 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。
 * 同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。
 * 一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。
 * 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取余 后返回。
 *
 * @author jd95288
 * @date 2025-09-09 8:57
 */
public class PeopleAwareOfSecret2327 {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[n + 1];
        int mod = 1000000007;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = Math.max(0, i - forget + 1); j <= Math.max(0, i - delay); j++) {
                dp[i] = (dp[i] + dp[j]) % mod;
            }
        }
        int res = 0;
        for (int i = Math.max(0, n - forget + 1); i <= n; i++) {
            res = (res + dp[i]) % mod;
        }
        return res;
    }

}
