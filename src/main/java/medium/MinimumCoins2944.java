package medium;

import java.util.Arrays;

/**
 * 购买水果需要的最少金币数
 * <p>
 * 给你一个 下标从 1 开始的 整数数组 prices ，其中 prices[i] 表示你购买第 i 个水果需要花费的金币数目。
 * 水果超市有如下促销活动：
 * - 如果你花费 prices[i] 购买了下标为 i 的水果，那么你可以免费获得下标范围在 [i + 1, i + i + 1] 的水果。
 * 注意 ，即使你 可以 免费获得水果 j ，你仍然可以花费 prices[j] 个金币去购买它以获得它的奖励。
 * 请你返回获得所有水果所需要的 最少 金币数。
 *
 * @author jd95288
 * @date 2025-01-24 9:07
 */
public class MinimumCoins2944 {

    public int minimumCoins(int[] prices) {
        int[] mem = new int[2 * prices.length + 3];
        Arrays.fill(mem, Integer.MAX_VALUE);
        return dfs(0, prices, mem, 0);
    }

    public int dfs(int index, int[] prices, int[] mem, int cost) {
        int n = prices.length;
        if (index >= n) {
            return cost;
        }
        int res = cost + prices[index];
        int next = index * 2 + 2;
        if (mem[next] == Integer.MAX_VALUE) {
            mem[next] = dfs(next, prices, mem, 0);
        }
        int remainder = mem[next];
        if (remainder == 0) {
            return res;
        }
        for (int i = index + 1; i < n && i <= index * 2 + 1; i++) {
            if (mem[i] == Integer.MAX_VALUE) {
                mem[i] = dfs(i, prices, mem, 0);
            }
            remainder = Math.min(mem[i], remainder);
        }
        return res + remainder;
    }

}
