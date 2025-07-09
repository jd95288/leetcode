package medium;

import java.util.Arrays;

/**
 * 重新安排会议得到最多空余时间 I
 * <p>
 * 给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
 * 同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为 [startTime[i], endTime[i]] 。
 * 你可以重新安排 至多 k 个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时间。
 * 移动前后所有会议之间的 相对 顺序需要保持不变，而且会议时间也需要保持互不重叠。
 * 请你返回重新安排会议以后，可以得到的 最大 空余时间。
 * 注意，会议 不能 安排到整个活动的时间以外。
 *
 * @author jd95288
 * @date 2025-07-09 8:52
 */
public class MaxFreeTime3439 {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[][] interval = new int[n + 2][2];
        interval[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            interval[i] = new int[]{startTime[i - 1], endTime[i - 1]};
        }
        interval[n + 1][0] = eventTime;
        Arrays.sort(interval, (a, b) -> a[0] - b[0]);
        int l = 1;
        int res = 0, sum = 0;
        for (int r = 1; r <= n; r++) {
            sum += interval[r][1] - interval[r][0];
            if (r - l == k - 1) {
                res = Math.max(res, interval[r + 1][0] - interval[l - 1][1] - sum);
                sum -= interval[l][1] - interval[l][0];
                l++;
            }
        }
        return res;
    }

}
