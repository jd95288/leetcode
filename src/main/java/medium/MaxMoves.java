package medium;


/**
 * 矩阵中移动的最大次数
 * <p>
 * 给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1)
 * 三个单元格中任一满足值 严格 大于当前单元格的单元格。
 * 返回你在矩阵中能够 移动 的 最大 次数。
 *
 * @author jd95288
 * @date 2024-03-16 15:08
 */
public class MaxMoves {

    public int maxMoves(int[][] grid) {
        int[][] dp = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            dp[i] = new int[grid[i].length];
        }
        int res = 0;
        int i = grid.length - 1;
        for (int j = grid[i].length - 2; j >= 0; j--) {
            i = grid.length - 1;
            for (; i >= 0; i--) {
                if (i != 0 && grid[i][j] < grid[i - 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + 1);
                }
                if (grid[i][j] < grid[i][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
                }
                if (i != grid.length - 1 && grid[i][j] < grid[i + 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 1);
                }
                if (j == 0){
                    res = Math.max(res, dp[i][0]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxMoves main = new MaxMoves();
        System.out.println(main.maxMoves(new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}));
    }
}
