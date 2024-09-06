package medium;

import java.util.Arrays;

/**
 * 搜索二维矩阵
 *
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2024-08-03 22:47
 */
public class SearchMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int[] firstColumn = new int[m];
        for (int i = 0; i < m; i++) {
            firstColumn[i] = matrix[i][0];
        }
        int i = Arrays.binarySearch(firstColumn, target);
        if (i < 0) {
            i = -i - 1;
        } else {
            i++;
        }
        return (i != 0 && i <= m) && Arrays.binarySearch(matrix[i - 1], target) >= 0;
    }

}
