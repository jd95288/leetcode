package medium;

/**
 * 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的 回文子串。
 *
 * @author jd95288
 * @date 2024-12-31 10:41
 */
public class LongestPalindrome5 {

    public String longestPalindrome(String s) {
        String res = String.valueOf(s.charAt(0));
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (dp[i][i + 1] && res.length() == 1) {
                    res = s.substring(i, i + 2);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (j - 1 >= 0 && i + 1 < n && dp[i + 1][j - 1]) {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    if (dp[i][j] && res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

}
