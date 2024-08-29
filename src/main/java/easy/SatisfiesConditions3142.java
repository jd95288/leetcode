package easy;

/**
 * 判断矩阵是否满足条件
 * <p>
 * 给你一个大小为 m x n 的二维矩阵 grid 。你需要判断每一个格子 grid[i][j] 是否满足：
 * 如果它下面的格子存在，那么它需要等于它下面的格子，也就是 grid[i][j] == grid[i + 1][j] 。
 * 如果它右边的格子存在，那么它需要不等于它右边的格子，也就是 grid[i][j] != grid[i][j + 1] 。
 * 如果 所有 格子都满足以上条件，那么返回 true ，否则返回 false 。
 *
 * @author jd95288
 * @date 2024-08-29 0:07
 */
public class SatisfiesConditions3142 {

    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            if (grid[i][0] != grid[i - 1][0]) {
                return false;
            }
        }
        for (int j = 1; j < n; j++) {
            if (grid[0][j] == grid[0][j - 1]) {
                return false;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == grid[i][j - 1] || grid[i][j] != grid[i - 1][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
