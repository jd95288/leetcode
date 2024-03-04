package easy;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author jd95288
 * @date 2024-03-03 1:44
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int profitSum = 0;
        int profitMax = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profitSum <= 0 && profit <= 0) {
                continue;
            }
            profitSum += profit;
            if (profit > profitSum) {
                profitSum = profit;
            }
            if (profitSum > profitMax) {
                profitMax = profitSum;
            }

        }
        return profitMax;
    }

}
