package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 按对角线进行矩阵排序
 *
 * 给你一个大小为 n x n 的整数方阵 grid。返回一个经过如下调整的矩阵：
 * 左下角三角形（包括中间对角线）的对角线按 非递增顺序 排序。
 * 右上角三角形 的对角线按 非递减顺序 排序。
 *
 * @author jd95288
 * @date 2025-08-28 8:57
 */
public class SortMatrix3446 {

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int k = n + n - 1;
        for (int l = 1; l < n; l++) {
            int maxJ = Math.min(n + n - l - 1, n - 1);
            int minJ = Math.max(0, n - l);
            List<Integer> list = new ArrayList<>();
            for (int j = minJ; j <= maxJ; j++) {
                int i = j + l - n;
                list.add(grid[i][j]);
            }
            Collections.sort(list);
            int p = 0;
            for (int j = minJ; j <= maxJ; j++) {
                int i = j + l - n;
                grid[i][j] = list.get(p++);
            }
        }
        for (int l = n; l <= k; l++) {
            int maxJ = Math.min(n + n - l - 1, n - 1);
            int minJ = Math.max(0, n - l);
            List<Integer> list = new ArrayList<>();
            for (int j = minJ; j <= maxJ; j++) {
                int i = j + l - n;
                list.add(grid[i][j]);
            }
            Collections.sort(list, Collections.reverseOrder());
            int p = 0;
            for (int j = minJ; j <= maxJ; j++) {
                int i = j + l - n;
                grid[i][j] = list.get(p++);
            }
        }
        return grid;
    }
}
