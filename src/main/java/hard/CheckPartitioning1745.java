package hard;

import java.util.Arrays;

/**
 * 分割回文串 IV
 * <p>
 * 给你一个字符串 s ，如果可以将它分割成三个 非空 回文子字符串，那么返回 true ，否则返回 false 。
 * 当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。
 *
 * @author jd95288
 * @date 2025-03-04 15:58
 */
public class CheckPartitioning1745 {

    public boolean checkPartitioning(String s) {
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
        char[][] mem = new char[n][4];
        return dfs(0, 3, isPalindrome, s, mem);
    }

    public boolean dfs(int i, int k, boolean[][] isPalindrome, String s, char[][] mem) {
        int n = s.length();
        if (i == n || k < 0) {
            return k == 0;
        }
        if (mem[i][k] != '\u0000') {
            return mem[i][k] == 'T';
        }
        boolean res = false;
        for (int j = i; j < n; j++) {
            if (isPalindrome[i][j]) {
                res = res || dfs(j + 1, k - 1, isPalindrome, s, mem);
            }
        }
        mem[i][k] = res ? 'T' : 'F';
        return res;
    }

}
