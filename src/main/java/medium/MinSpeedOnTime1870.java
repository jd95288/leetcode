package medium;

/**
 * 准时到达的列车最小时速
 * <p>
 * 给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。另给你一个长度为 n 的整数数组 dist ，其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
 * 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
 * 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
 * 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
 * 生成的测试用例保证答案不超过 107 ，且 hour 的 小数点后最多存在两位数字 。
 *
 * @author jd95288
 * @date 2024-10-02 21:44
 */
public class MinSpeedOnTime1870 {

    public int minSpeedOnTime(int[] dist, double hour) {
        long sum = 0;
        int max = 0;
        for (int value : dist) {
            sum += value;
            max = Math.max(max, value);
        }
        max *= 100;
        int v = (int) Math.ceil(sum / hour - 0.5);
        long l = v, r = max, m = l + (r - l) / 2;
        while (l <= r) {
            if (check(dist, hour, m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = l + (r - l) / 2;
        }
        return l > max ? -1 : (int)l;
    }

    private boolean check(int[] dist, double hour, long m) {
        int n = dist.length;
        double cost = 0;
        for (int i = 0; i < n - 1; i++) {
            cost += Math.ceil((double) dist[i] / m);
        }
        cost += (double) dist[n - 1] / m;
        return cost <= hour;
    }

}
