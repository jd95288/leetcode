package medium;

import java.util.Arrays;

/**
 * 坐上公交的最晚时间
 * <p>
 * 给你一个下标从 0 开始长度为 n 的整数数组 buses ，其中 buses[i] 表示第 i 辆公交车的出发时间。同时给你一个下标从 0 开始长度为 m 的整数数组 passengers ，其中 passengers[j] 表示第 j 位乘客的到达时间。所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同。
 * 给你一个整数 capacity ，表示每辆公交车 最多 能容纳的乘客数目。
 * 每位乘客都会搭乘下一辆有座位的公交车。如果你在 y 时刻到达，公交在 x 时刻出发，满足 y <= x  且公交没有满，那么你可以搭乘这一辆公交。最早 到达的乘客优先上车。
 * 返回你可以搭乘公交车的最晚到达公交站时间。你 不能 跟别的乘客同时刻到达。
 * 注意：数组 buses 和 passengers 不一定是有序的。
 *
 * @author jd95288
 * @date 2024-09-18 10:41
 */
public class LatestTimeCatchTheBus2332 {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int n = buses.length;
        int m = passengers.length;
        int i = 0, j = 0, cnt = capacity;
        for (; i < n; i++) {
            cnt = capacity;
            while (cnt > 0 && j < m && passengers[j] <= buses[i]) {
                cnt--;
                j++;
            }
        }
        int res;
        j--;
        if (cnt > 0) {
            res = buses[n - 1];
        } else {
            res = passengers[j];
        }
        while (j >= 0 && passengers[j] == res) {
            res--;
            j--;
        }
        return res;
    }

}
