package easy;

/**
 * 最少翻转次数使二进制矩阵回文I
 * <p>
 * 给你一个 m x n 的二进制矩阵 grid 。
 * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
 * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
 * 请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。
 *
 * @author jd95288
 * @date 2024-11-15 9:05
 */
public class MinFlips3239 {

    public int minFlips(int[][] grid) {
        int rowOpts = 0;
        int colOpts = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                rowOpts += grid[i][j] ^ grid[i][n - 1 - j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                colOpts += grid[j][i] ^ grid[m - j - 1][i];
            }
        }
        return Math.min(rowOpts, colOpts);
    }

}
