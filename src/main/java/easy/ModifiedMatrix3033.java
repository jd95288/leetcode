package easy;

/**
 * 修改矩阵
 * 给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，
 * 新建一个下标从 0 开始、名为 answer 的矩阵。使 answer 与 matrix 相等，
 * 接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。
 * 返回矩阵 answer 。
 *
 * @author jd95288
 * @date 2024-07-05 0:26
 */
public class ModifiedMatrix3033 {

    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == -1) {
                    matrix[j][i] = max;
                }
            }
        }
        return matrix;
    }

}
