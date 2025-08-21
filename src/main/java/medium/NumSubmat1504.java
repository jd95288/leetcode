package medium;

/**
 * 统计全 1 子矩形
 * <p>
 * 给你一个 m x n 的二进制矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 *
 * @author jd95288
 * @date 2025-08-21 8:48
 */
public class NumSubmat1504 {

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        for (int u = 0; u < m; u++) {
            for (int l = u; l < m; l++) {
                int h = l - u + 1;
                int[] row = new int[n];
                for (int i = u; i <= l; i++) {
                    for (int j = 0; j < n; j++) {
                        row[j] += mat[i][j];
                    }
                }
                int p = 0;
                while (p < n) {
                    if (row[p] != h) {
                        p++;
                        continue;
                    }
                    int start = p;
                    while (p < n && row[p] == h) {
                        p++;
                    }
                    int cnt = p - start;
                    res += (cnt + 1) * cnt / 2;
                }
            }
        }
        return res;
    }

}
