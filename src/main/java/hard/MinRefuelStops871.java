package hard;

import java.util.PriorityQueue;

/**
 * 最低加油次数
 * <p>
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * 沿途有加油站，用数组 stations 表示。其中 stations[i] = [positioni, fueli] 表示第 i 个加油站位于出发位置东面 positioni 英里处，并且有 fueli 升汽油。
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。
 * 如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 *
 * @author jd95288
 * @date 2024-10-07 21:09
 */
public class MinRefuelStops871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int n = stations.length;
        int i = 0;
        int res = 0;
        int fuel = startFuel;
        while (fuel < target) {
            while (i < n && fuel >= stations[i][0]) {
                q.offer(stations[i++][1]);
            }
            if (!q.isEmpty()) {
                fuel += q.poll();
                res++;
                if (fuel >= target) {
                    return res;
                }
            } else if (i == n || fuel < stations[i][0]) {
                // 没有剩余的加油站了，或者无法抵达
                return -1;
            }
        }
        return res;
    }

}
