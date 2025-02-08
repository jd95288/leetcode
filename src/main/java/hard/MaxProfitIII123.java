package hard;


/**
 * 买卖股票的最佳时机III
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author jd95288
 * @date 2025-02-08 11:03
 */
public class MaxProfitIII123 {

    public int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;
        int[] dp = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            int prev = i >= 1 ? dp[i - 1] : 0;
            res = Math.max(res, prev + max - prices[i]);
        }
        return res;
    }

}
