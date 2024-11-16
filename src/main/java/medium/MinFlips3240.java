package medium;

/**
 * 最少翻转次数使二进制矩阵回文II
 * <p>
 * 给你一个 m x n 的二进制矩阵 grid 。
 * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
 * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
 * 请你返回 最少 翻转次数，使得矩阵中 所有 行和列都是 回文的 ，且矩阵中 1 的数目可以被 4 整除 。
 *
 * @author jd95288
 * @date 2024-11-15 11:28
 */
public class MinFlips3240 {

    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int rowMid = m / 2;
        int colMid = n / 2;
        for (int i = 0; i < rowMid; i++) {
            for (int j = 0; j < colMid; j++) {
                int jj = n - j - 1;
                int ii = m - i - 1;
                int sum = grid[i][j] + grid[i][jj] + grid[ii][j] + grid[ii][jj];
                res += Math.min(sum, 4 - sum);
            }
        }
        int midRowOneCnt = 0;
        int midRowOptCnt = 0;
        if (m % 2 == 1) {
            for (int j = 0; j < colMid; j++) {
                int jj = n - j - 1;
                midRowOneCnt += grid[rowMid][j] + grid[rowMid][jj];
                midRowOptCnt += grid[rowMid][j] ^ grid[rowMid][jj];
            }
        }
        int midColOneCnt = 0;
        int midColOptCnt = 0;
        if (n % 2 == 1) {
            for (int i = 0; i < rowMid; i++) {
                int ii = m - i - 1;
                midColOneCnt += grid[i][colMid] + grid[ii][colMid];
                midColOptCnt += grid[i][colMid] ^ grid[ii][colMid];
            }
        }
        int midOpt = midRowOptCnt + midColOptCnt;
        res += midOpt;
        int midOneCnt = midRowOneCnt + midColOneCnt;
        int mod = midOneCnt % 4;
        int remainder;
        if (m + n <= 4) {
            remainder = midOpt - mod;
        } else {
            remainder = midOpt - Math.min(mod, 4 - mod);
        }
        if (remainder < 0) {
            res += -remainder;
        }
        if (m % 2 == 1 && n % 2 == 1) {
            res += grid[rowMid][colMid];
        }

        return res;
    }

}
