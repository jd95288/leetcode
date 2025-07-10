package medium;

import java.util.Arrays;

/**
 * 重新安排会议得到最多空余时间 II
 * <p>
 * 给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
 * 同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为 [startTime[i], endTime[i]] 。
 * 你可以重新安排 至多 一个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时间。
 * 请你返回重新安排会议以后，可以得到的 最大 空余时间。
 * 注意，会议 不能 安排到整个活动的时间以外，且会议之间需要保持互不重叠。
 * 注意：重新安排会议以后，会议之间的顺序可以发生改变。
 *
 * @author jd95288
 * @date 2025-07-10 22:15
 */
public class MaxFreeTime3440 {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gap = new int[n + 1];
        int[] intervals = new int[n];
        Arrays.setAll(intervals, i -> endTime[i] - startTime[i]);
        int[] a = new int[]{0, 0};
        int[] b = new int[]{0, 0};
        int[] c = new int[]{0, 0};
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                gap[i] = startTime[i];
            } else if (i == n) {
                gap[i] = eventTime - endTime[i - 1];
            } else {
                gap[i] = startTime[i] - endTime[i - 1];
            }
            if (gap[i] >= a[0]) {
                c = b;
                b = a;
                a = new int[]{gap[i], i};
            } else if (gap[i] >= b[0]) {
                c = b;
                b = new int[]{gap[i], i};
            } else if (gap[i] >= c[0]) {
                c = new int[]{gap[i], i};
            }
        }
        int res = a[0];
        for (int i = 0; i < n; i++) {
            int g = gap[i] + gap[i + 1];
            if (intervals[i] > a[0]) {
                res = Math.max(res, g);
            } else if (intervals[i] <= c[0]) {
                res = Math.max(res, g + intervals[i]);
            } else if (intervals[i] <= b[0] && (b[1] != i && b[1] != i + 1)) {
                res = Math.max(res, g + intervals[i]);
            } else if (a[1] != i && a[1] != i + 1) {
                res = Math.max(res, g + intervals[i]);
            } else {
                res = Math.max(res, g);
            }
        }
        return res;
    }

}
