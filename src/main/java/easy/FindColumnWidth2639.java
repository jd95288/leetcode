package easy;

/**
 * 查询网格图中每一列的宽度
 * <p>
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 。矩阵中某一列的宽度是这一列数字的最大 字符串长度 。
 * 比方说，如果 grid = [[-10], [3], [12]] ，那么唯一一列的宽度是 3 ，因为 -10 的字符串长度为 3 。
 * 请你返回一个大小为 n 的整数数组 ans ，其中 ans[i] 是第 i 列的宽度。
 * 一个有 len 个数位的整数 x ，如果是非负数，那么 字符串长度 为 len ，否则为 len + 1 。
 *
 * @author jd95288
 * @date 2024-04-27 18:39
 */
public class FindColumnWidth2639 {
    public int h(int value) {
        int res = 0;
        if (value < 0) {
            value = -value;
            res++;
        }
        if (value < 10) {
            res += 1;
        } else if (value < 100) {
            res += 2;
        } else if (value < 1000) {
            res += 3;
        } else if (value < 10000) {
            res += 4;
        } else if (value < 100000) {
            res += 5;
        } else if (value < 1000000) {
            res += 6;
        } else if (value < 10000000) {
            res += 7;
        } else if (value < 100000000) {
            res += 8;
        } else if (value < 1000000000) {
            res += 9;
        } else {
            res += 10;
        }

        return res;
    }


    public int[] findColumnWidth(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                res[j] = Math.max(res[j], h(grid[i][j]));
            }
        }
        return res;
    }
}
