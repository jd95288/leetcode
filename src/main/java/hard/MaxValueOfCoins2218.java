package hard;

import java.util.List;

/**
 * 从栈中取出K个硬币的最大面值和
 * <p>
 * 一张桌子上总共有 n 个硬币 栈 。每个栈有 正整数 个带面值的硬币。
 * 每一次操作中，你可以从任意一个栈的 顶部 取出 1 个硬币，从栈中移除它，并放入你的钱包里。
 * 给你一个列表 piles ，其中 piles[i] 是一个整数数组，分别表示第 i 个栈里 从顶到底 的硬币面值。
 * 同时给你一个正整数 k ，请你返回在 恰好 进行 k 次操作的前提下，你钱包里硬币面值之和 最大为多少 。
 *
 * @author jd95288
 * @date 2025-01-21 13:46
 */
public class MaxValueOfCoins2218 {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] prefix = new int[n][];
        for (int i = 0; i < n; i++) {
            List<Integer> pile = piles.get(i);
            prefix[i] = new int[pile.size() + 1];
            for (int j = 1; j <= pile.size(); j++) {
                prefix[i][j] = prefix[i][j - 1] + pile.get(j - 1);
            }
        }
        int[][] dp = new int[n][k + 1];
        for (int j = 1; j <= k; j++) {
            int length = piles.get(0).size();
            if (j <= length) {
                dp[0][j] = prefix[0][j];
            } else {
                dp[0][j] = dp[0][length];
            }
        }
        for (int i = 1; i < n; i++) {
            int length = piles.get(i).size();
            for (int j = 1; j <= k; j++) {
                for (int x = 1; x <= length && j >= x; x++) {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i - 1][j - x] + prefix[i][x]));
                }
            }
        }
        return dp[n - 1][k];
    }

}
