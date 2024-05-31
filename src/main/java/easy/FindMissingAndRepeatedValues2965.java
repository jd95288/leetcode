package easy;

/**
 * 找出缺失和重复的数字
 *
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n^2] 范围内。
 * 除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 * 任务是找出重复的数字a 和缺失的数字 b 。
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 *
 * @author jd95288
 * @date 2024-05-31 0:12
 */
public class FindMissingAndRepeatedValues2965 {

    /** 执行通过*/
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int l = m * n + 1;
        int[] occurrence = new int[l];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                occurrence[grid[i][j]]++;
            }
        }
        int[] res = new int[2];
        for (int i = 1; i < l; i++) {
            if (occurrence[i] == 0) {
                res[1] = i;
            } else if (occurrence[i] == 2) {
                res[0] = i;
            }
        }
        return res;
    }
}
