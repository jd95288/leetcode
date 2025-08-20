package medium;

/**
 * 统计全为 1 的正方形子矩阵
 * <p>
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 * @author jd95288
 * @date 2025-08-20 8:44
 */
public class CountSquares1277 {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 1) {
                    continue;
                }
                int max = Math.min(m - i, n - j);
                int l = 1;
                here:
                for (; l < max; l++) {
                    for (int y = i + l; y >= i; y--) {
                        if (matrix[y][j + l] == 0) {
                            break here;
                        }
                    }
                    for (int x = j + l; x >= j; x--) {
                        if (matrix[i + l][x] == 0) {
                            break here;
                        }
                    }
                }
                res += l;
//                // 不能用下面的写法去算，因为没有考虑重复的情况
//                for (int k = 1; k <= l; k++) {
//                    res += (l - k + 1) * (l - k + 1);
//                }
            }
        }
        return res;
    }

}
