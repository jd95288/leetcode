package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @author jd95288
 * @date 2025-01-18 22:15
 */
public class SetZeroes73 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (Integer i : row) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer j : col) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
