package medium;

/**
 * 对角线遍历
 * <p>
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 * @author jd95288
 * @date 2025-08-25 8:51
 */
public class FindDiagonalOrder498 {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int l = m + n - 1;
        int[] res = new int[m * n];
        int p = 0;
        for (int k = 1; k <= l; k++) {
            int minJ = Math.max(0, k - m);
            int maxJ = Math.min(k - 1, n - 1);
            if (k % 2 == 0) {
                for (int j = maxJ; j >= minJ; j--) {
                    res[p++] = mat[k - 1 - j][j];
                }
            } else {
                for (int j = minJ; j <= maxJ; j++) {
                    res[p++] = mat[k - 1 - j][j];
                }
            }
        }
        return res;
    }

}
