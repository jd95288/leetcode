package medium;

import java.util.PriorityQueue;

/**
 * 吃苹果的最大数目
 * <p>
 * 有一颗特殊的苹果树，第 i 天会结出 apples[i] 个果子，
 * 这些果子将在第 i + days[i] 天腐烂。求每天吃一个未腐烂的苹果，最多可以吃几个。
 *
 * @author jd95288
 * @date 2024-12-24 10:35
 */
public class EatenApples1705 {

    public int eatenApples_v2(int[] apples, int[] days) {
        int n = apples.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int res = 0;
        for (int day = 0; day < n || !q.isEmpty(); day++) {
            if (day < n && apples[day] > 0){
                q.offer(new int[]{apples[day], day + days[day]});
            }
            while (!q.isEmpty()) {
                int[] applesInfo = q.peek();
                if (applesInfo[0] == 0 || applesInfo[1] == day) {
                    q.poll();
                    continue;
                }
                if (applesInfo[1] > day && applesInfo[0] > 0) {
                    applesInfo[0]--;
                    res++;
                    break;
                }
            }
        }
        return res;
    }

}
