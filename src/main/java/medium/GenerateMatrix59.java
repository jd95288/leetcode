package medium;


/**
 * 螺旋矩阵 II
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * @author jd95288
 * @date 2025-02-07 0:11
 */
public class GenerateMatrix59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, num = 1, d = 0;
        int step = n, next = n;
        int cnt = 0;
        for (int i = 0; i < n * n; i++) {
            matrix[x][y] = num++;
            cnt++;
            if (cnt == step) {
                int tmp = step;
                step = next - 1;
                next = tmp;
                d = (d + 1) % 4;
                cnt = 0;
            }
            x += direction[d][0];
            y += direction[d][1];
        }
        return matrix;
    }

}
