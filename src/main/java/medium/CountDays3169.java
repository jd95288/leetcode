package medium;

import java.util.Arrays;

/**
 * 无需开会的工作日
 *
 * 给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。
 * 另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。
 * 返回员工可工作且没有安排会议的天数。
 * 注意：会议时间可能会有重叠。
 *
 * @author jd95288
 * @date 2025-07-11 18:53
 */
public class CountDays3169 {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int res = 0;
        int prevEnd = 0;
        for (int[] meeting : meetings) {
            int interval = meeting[0] - prevEnd - 1;
            res += Math.max(interval, 0);
            prevEnd = Math.max(prevEnd, meeting[1]);
        }
        return res + Math.max(0, days - prevEnd);
    }

}
