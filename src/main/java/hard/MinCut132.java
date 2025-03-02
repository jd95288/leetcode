package hard;

import java.util.Arrays;

/**
 * 分割回文串 II
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的 最少分割次数 。
 *
 * @author jd95288
 * @date 2025-03-02 0:10
 */
public class MinCut132 {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (boolean[] row : isPalindrome) {
            Arrays.fill(row, true);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                continue;
            }
            int res = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    res = Math.min(res, dp[j - 1] + 1);
                }
            }
            dp[i] = res;
        }
        return dp[n - 1];

    }

}
