package medium;

/**
 * 最大正方形
 * <p>
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * @author jd95288
 * @date 2025-04-13 1:38
 */
public class MaximalSquare221 {

    /**
     * 执行通过
     * 参照官网的写法，将初始化放到了循环内
     * 此外，重新定义了 dp 含义，dp[i][j] 表示以 (i,j) 为左上顶点的全一正方形的最大边长
     */
    public int maximalSquare_v2(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

}
