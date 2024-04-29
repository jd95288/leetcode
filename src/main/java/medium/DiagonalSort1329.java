package medium;

import java.util.PriorityQueue;

/**
 * 将矩阵按对角线排序
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。
 * 例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
 *
 * @author jd95288
 * @date 2024-04-29 0:26
 */
public class DiagonalSort1329 {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i;
        int j;
        PriorityQueue<Integer> q = new PriorityQueue();
        for (int col = 0; col < n; col++) {
            j = col;
            i = 0;
            while (i < m && j < n) {
                q.offer(mat[i++][j++]);
            }
            j = col;
            i = 0;
            while (i < m && j < n) {
                mat[i++][j++] = q.poll();
            }
        }
        for (int row = 1; row < m; row++) {
            j = 0;
            i = row;
            while (i < m && j < n) {
                q.offer(mat[i++][j++]);
            }
            j = 0;
            i = row;
            while (i < m && j < n) {
                mat[i++][j++] = q.poll();
            }
        }

        return mat;
    }

}
