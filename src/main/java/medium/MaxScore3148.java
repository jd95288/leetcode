package medium;

import java.util.List;

/**
 * 矩阵中的最大得分
 * <p>
 * 给你一个由 正整数 组成、大小为 m x n 的矩阵 grid。
 * 你可以从矩阵中的任一单元格移动到另一个位于正下方或正右侧的任意单元格（不必相邻）。从值为 c1 的单元格移动到值为 c2 的单元格的得分为 c2 - c1 。
 * 你可以从 任一 单元格开始，并且必须至少移动一次。
 * 返回你能得到的 最大 总得分。
 *
 * @author jd95288
 * @date 2024-08-15 0:22
 */
public class MaxScore3148 {

    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dp = new int[m][n];
        int res = Integer.MIN_VALUE;
        dp[m - 1][n - 1] = grid.get(m - 1).get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int cur = grid.get(m - 1).get(i);
            res = Math.max(dp[m - 1][i + 1] - cur, res);
            dp[m - 1][i] = Math.max(cur, dp[m - 1][i + 1]);
        }
        for (int i = m - 2; i >= 0; i--) {
            int cur = grid.get(i).get(n - 1);
            res = Math.max(dp[i + 1][n - 1] - cur, res);
            dp[i][n - 1] = Math.max(cur, dp[i + 1][n - 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int cur = grid.get(i).get(j);
                res = Math.max(dp[i + 1][j] - cur, res);
                res = Math.max(dp[i][j + 1] - cur, res);
                dp[i][j] = Math.max(cur, dp[i + 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j + 1]);
            }
        }
        return res;
    }

}
