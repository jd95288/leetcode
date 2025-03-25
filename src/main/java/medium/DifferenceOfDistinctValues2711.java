package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 对角线上不同值的数量差
 * <p>
 * 给你一个下标从 0 开始、大小为 m x n 的二维矩阵 grid ，请你求解大小同样为 m x n 的答案矩阵 answer 。
 * 矩阵 answer 中每个单元格 (r, c) 的值可以按下述方式进行计算：
 * 令 topLeft[r][c] 为矩阵 grid 中单元格 (r, c) 左上角对角线上 不同值 的数量。
 * 令 bottomRight[r][c] 为矩阵 grid 中单元格 (r, c) 右下角对角线上 不同值 的数量。
 * 然后 answer[r][c] = |topLeft[r][c] - bottomRight[r][c]| 。
 * 返回矩阵 answer 。
 * 矩阵对角线 是从最顶行或最左列的某个单元格开始，向右下方向走到矩阵末尾的对角线。
 * 如果单元格 (r1, c1) 和单元格 (r, c) 属于同一条对角线且 r1 < r ，则单元格 (r1, c1) 属于单元格 (r, c) 的左上对角线。类似地，可以定义右下对角线。
 *
 * @author jd95288
 * @date 2025-03-25 0:12
 */
public class DifferenceOfDistinctValues2711 {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m + n - 1; i++) {
            int row = i / n < 1 ? 0 : i - n + 1 % m;
            int col = row > 0 ? 0 : n - 1 - i;
            Set<Integer> set = new HashSet<>();
            while (row < m && col < n){
                res[row][col] = set.size();
                set.add(grid[row][col]);
                row++;
                col++;
            }
            row--;
            col--;
            set.clear();
            while (row >= 0 && col >= 0){
                res[row][col] = Math.abs(res[row][col] - set.size());
                set.add(grid[row][col]);
                row--;
                col--;
            }
        }
        return res;
    }

}
