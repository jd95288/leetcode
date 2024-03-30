package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 统计将重叠区间合并成组的方案数
 * <p>
 * 给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整数都包含在第 i 个区间中。
 * 你需要将 ranges 分成 两个 组（可以为空），满足：
 * 每个区间只属于一个组。
 * 两个有 交集 的区间必须在 同一个 组内。
 * 如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。
 * 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。
 * 请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 10^9 + 7 取余 后返回。
 *
 * @author jd95288
 * @date 2024-03-27 8:36
 */
public class CountWays2580 {

    private static final int MOD = 1000000007;

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int left = -1;
        int cnt = 0;
        for (int[] range : ranges) {
            if (range[0] > left) {
                cnt++;
            }
            left = Math.max(range[1], left);
        }
        long res = 1;
        long base = 2L;
        while (cnt > 0) {
            if ((cnt & 1) == 1) {
                res = res * base % MOD;
            }
            base = base * base % MOD;
            cnt >>= 1;
        }
        return (int)res;
    }

}
