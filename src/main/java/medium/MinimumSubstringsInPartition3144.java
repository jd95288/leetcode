package medium;

import java.util.Arrays;

/**
 * 分割字符频率相等的最少子字符串
 * <p>
 * 给你一个字符串 s ，你需要将它分割成一个或者更多的 平衡 子字符串。
 * 比方说，s == "ababcc" 那么 ("abab", "c", "c") ，("ab", "abc", "c") 和 ("ababcc") 都是合法分割，
 * 但是 ("a", "bab", "cc") ，("aba", "bc", "c") 和 ("ab", "abcc") 不是，不平衡的子字符串用粗体表示。
 * 请你返回 s 最少 能分割成多少个平衡子字符串。
 * 注意：一个 平衡 字符串指的是字符串中所有字符出现的次数都相同。
 *
 * @author jd95288
 * @date 2024-08-28 10:29
 */
public class MinimumSubstringsInPartition3144 {

    public int minimumSubstringsInPartition_v2(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cnt, 0);
            int k = 0, max = 0;
            for (int j = i; j >= 0; j--) {
                int index = s.charAt(j) - 'a';
                k += ++cnt[index] == 1 ? 1 : 0;
                max = Math.max(cnt[index], max);
                if (k * max == i - j + 1) {
                    dp[i + 1] = Math.min(dp[j] + 1, dp[i + 1]);
                }
            }
        }
        return dp[n];
    }
}
