package medium;

/**
 * 骑士在棋盘上的概率
 * <p>
 * 在 n x n 棋盘上的 (row, column) 位置上有一个骑士（坐标从 0 开始），
 * 问它朝 8 个方向任意走 k 次还停留在棋盘上的概率是多少。
 *
 * @author jd95288
 * @date 2024-12-07 20:48
 */
public class KnightProbability688 {

    public double knightProbability(int n, int k, int row, int column) {
        int[][] direction = new int[][]{{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, 2}, {2, 1}, {1, -2}, {2, -1}};
        double[][][] dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1.0;
            }
        }
        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int d = 0; d < 8; d++) {
                        int dx = direction[d][0];
                        int dy = direction[d][1];
                        int x = i + dx;
                        int y = j + dy;
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            dp[i][j][step] += dp[x][y][step - 1];
                        }
                    }
                    dp[i][j][step] /= 8;
                }
            }
        }
        return dp[row][column][k];
    }

}
