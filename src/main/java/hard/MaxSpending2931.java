package hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 购买物品的最大开销
 * <p>
 * 有 m 个商店，每个商店里有 n 个商品。values[i][j] 表示商店 i 中商品 j 的价值，
 * values[i] 非严格递减。从第一天开始，在第 d 天，我们可以选择一个商店 i，
 * 花费 d * values[i][j] 购买剩余的商品中价值中最小的商品 j。
 * <p>
 * 返回购买完所有商店的所有商品所需的最大开销。
 *
 * @author jd95288
 * @date 2024-12-12 14:11
 */
public class MaxSpending2931 {

    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>(m, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            q.offer(new int[]{values[i][n - 1], i, n - 1});
        }
        long res = 0L;
        long d = 1L;
        while (!q.isEmpty()) {
            int[] goods = q.poll();
            int storeIndex = goods[1];
            res += d++ * goods[0];
            int p = --goods[2];
            if (p >= 0) {
                q.offer(new int[]{values[storeIndex][p], storeIndex, p});
            }
        }
        return res;
    }

}
