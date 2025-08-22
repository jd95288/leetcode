package medium;

/**
 * 包含所有 1 的最小矩形面积 I
 * <p>
 * 给你一个二维 二进制 数组 grid。
 * 请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。
 * 返回这个矩形可能的 最小 面积。
 *
 * @author jd95288
 * @date 2025-08-22 10:08
 */
public class MinimumArea3195 {

    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rowMin = m - 1, rowMax = 0;
        int colMin = n - 1, colMax = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowMin = Math.min(rowMin, i);
                    rowMax = Math.max(rowMax, i);
                    colMin = Math.min(colMin, j);
                    colMax = Math.max(colMax, j);
                }
            }
        }
        return (rowMax - rowMin + 1) * (colMax - colMin + 1);
    }

}
