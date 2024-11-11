package hard;

import java.util.Arrays;

/**
 * 切棍子的最小成本
 * <p>
 * 有一个长度为 n 的木棍，刻度从 0 ~ n，有一个整数数组 cuts，
 * cuts[i] 表示需要在刻度 i 处进行切割，切割的成本为该刻度所在棍子的长度，求切割棍子的最小成本。
 *
 * @author jd95288
 * @date 2024-11-11 10:07
 */
public class MinCost1547 {

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] endpoint = new int[m + 2];
        System.arraycopy(cuts, 0, endpoint, 1, m);
        endpoint[m + 1] = n;

        m = endpoint.length;
        int[][] dp = new int[m][m];

        for (int i = m - 3; i >= 0; i--) {
            for (int j = i + 2; j < m; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = j - 1; k > i; k--) {
                    min = Math.min(dp[i][k] + dp[k][j], min);
                }
                dp[i][j] = min + endpoint[j] - endpoint[i];
            }
        }
        return dp[0][m - 1];
    }

}
