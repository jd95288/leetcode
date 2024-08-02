package medium;

/**
 * 直角三角形
 * <p>
 * 给你一个二维 boolean 矩阵 grid 。
 * 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。
 * 注意：
 * 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，
 * 那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相之间不需要相邻。
 *
 * @author jd95288
 * @date 2024-08-02 14:37
 */
public class NumberOfRightTriangles3128 {

    public long numberOfRightTriangles(int[][] grid) {
        long res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] colSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colSum[j] += grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            for (int j = 0; j < n; j++) {
                res += grid[i][j] * (rowSum - 1) * (colSum[j] - 1);
            }
        }
        return res;
    }

}
