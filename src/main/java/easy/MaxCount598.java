package easy;

/**
 * 区间加法 II
 *
 * 给你一个 m x n 的矩阵 M 和一个操作数组 op 。
 * 矩阵初始化时所有的单元格都为 0 。
 * ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 *
 * @author jd95288
 * @date 2025-02-02 1:23
 */
public class MaxCount598 {

    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }
        return x * y;
    }

}
