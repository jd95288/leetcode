package medium;

/**
 * 构成整天的下标对数目 II
 * <p>
 * 给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，
 * 表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 i, j 的数目。
 * 整天 定义为时间持续时间是 24 小时的 整数倍 。
 * 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
 *
 * @author jd95288
 * @date 2024-10-23 10:16
 */
public class CountCompleteDayPairs3185 {

    public long countCompleteDayPairs(int[] hours) {
        long res = 0L;
        int[] cnt = new int[24];
        int zeroCnt = 0;
        for (int hour : hours) {
            int m = hour % 24;
            if (m == 0) {
                res += zeroCnt;
                zeroCnt++;
            } else {
                res += cnt[24 - m];
                cnt[m]++;
            }
        }
        return res;
    }

}
