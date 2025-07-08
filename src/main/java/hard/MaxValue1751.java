package hard;

import java.util.Arrays;

/**
 * 最多可以参加的会议数目 II
 * <p>
 * 给你一个 events 数组，其中 events[i] = [startDayi, endDayi, valuei] ，
 * 表示第 i 个会议在 startDayi 天开始，第 endDayi 天结束，如果你参加这个会议，你能得到价值 valuei 。
 * 同时给你一个整数 k 表示你能参加的最多会议数目。
 * 你同一时间只能参加一个会议。如果你选择参加某个会议，那么你必须 完整 地参加完这个会议。
 * 会议结束日期是包含在会议内的，也就是说你不能同时参加一个开始日期与另一个结束日期相同的两个会议。
 * <p>
 * 请你返回能得到的会议价值 最大和 。
 *
 * @author jd95288
 * @date 2025-07-08 8:47
 */
public class MaxValue1751 {

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            int prev = find(events, events[i][0]);
            for (int j = 1; j <= k; j++) {
                dp[i + 1][j] = Math.max(dp[i][j], dp[prev + 1][j - 1] + events[i][2]);
            }
        }
        return dp[n][k];
    }

    public int find(int[][] events, int target) {
        int r = events.length - 1;
        int l = 0;
        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (events[mid][1] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            mid = l + (r - l) / 2;
        }
        return r;
    }

}
