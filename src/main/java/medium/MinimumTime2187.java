package medium;

/**
 * 完成旅途的最少时间
 * <p>
 * 给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
 * 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行且互不影响。
 * 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
 *
 * @author jd95288
 * @date 2024-10-05 21:34
 */
public class MinimumTime2187 {

    public long minimumTime(int[] time, int totalTrips) {
        long l = 0L, r = 100000000000000L;
        long m = l + (r - l) / 2;
        while (l <= r) {
            if (check(time, totalTrips, m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = l + (r - l) / 2;
        }
        return l;
    }

    private boolean check(int[] time, int totalTrips, long least) {
        long cnt = 0L;
        for (int i : time) {
            cnt += least / i;
            if (cnt >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
