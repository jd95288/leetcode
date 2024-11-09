package easy;

/**
 * 设计相邻元素求和服务
 * <p>
 * 有一个 `n x n` 的二维矩阵，其元素值的范围在 `0 ~ n^2 - 1`，且互不相同。
 * 给定一个元素值，求其上下左右的元素和、对角线元素和（左上、右上、左下和右下）。
 *
 * @author jd95288
 * @date 2024-11-09 11:21
 */
public class NeighborSum3242 {

    class NeighborSum {

        int[][] adjacent = new int[][]{
                new int[]{-1, 0},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{0, 1},
        };
        int[][] diagonal = new int[][]{
                new int[]{-1, -1},
                new int[]{-1, 1},
                new int[]{1, -1},
                new int[]{1, 1},
        };
        int[] adjacentSum;
        int[] diagonalSum;

        public NeighborSum(int[][] grid) {
            int index = 0;
            int n = grid.length;
            int length = n * n;
            adjacentSum = new int[length];
            diagonalSum = new int[length];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = grid[i][j];
                    adjacentSum[value] = sum(grid, i, j, adjacent);
                    diagonalSum[value] = sum(grid, i, j, diagonal);
                }
            }
        }

        public int adjacentSum(int value) {
            return adjacentSum[value];
        }

        public int diagonalSum(int value) {
            return diagonalSum[value];
        }

        private int sum(int[][] grid, int i, int j, int[][] directions){
            int res = 0;
            for (int[] direction : directions) {
                int row = direction[0] + i;
                int col = direction[1] + j;
                if (row < 0 || col < 0 || row >= grid.length || col >= grid.length) {
                    continue;
                }
                res += grid[row][col];
            }
            return res;
        }
    }

}
