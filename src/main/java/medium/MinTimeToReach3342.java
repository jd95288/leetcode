package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 到达最后一个房间的最少时间 II
 * <p>
 * 有一个地窖，地窖中有 n x m 个房间，它们呈网格状排布。
 * 给你一个大小为 n x m 的二维数组 moveTime ，其中 moveTime[i][j] 表示在这个时刻 以后 你才可以 开始 往这个房间 移动 。你在时刻 t = 0 时从房间 (0, 0) 出发，每次可以移动到 相邻 的一个房间。在 相邻 房间之间移动需要的时间为：第一次花费 1 秒，第二次花费 2 秒，第三次花费 1 秒，第四次花费 2 秒……如此 往复 。
 * 请你返回到达房间 (n - 1, m - 1) 所需要的 最少 时间。
 * 如果两个房间有一条公共边（可以是水平的也可以是竖直的），那么我们称这两个房间是 相邻 的。
 *
 * @author jd95288
 * @date 2025-05-08 8:57
 */
public class MinTimeToReach3342 {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = dijkstra(moveTime);
        return dist[n - 1][m - 1];
    }

    public int[][] dijkstra(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.offer(new int[]{0, 0, 0, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int a = cur[0];
                int b = cur[1];
                if (a == n - 1 && b == m - 1) {
                    return dist;
                }
                if (cur[2] > dist[a][b]) {
                    continue;
                }
                int cnt = cur[3];
                for (int[] direction : directions) {
                    int x = a + direction[0];
                    int y = b + direction[1];
                    if (x < n && x >= 0 && y >= 0 && y < m) {
                        int time = Math.max(g[x][y], dist[a][b]) + (cnt % 2 == 0 ? 1 : 2);
                        if (dist[x][y] > time) {
                            dist[x][y] = time;
                            q.offer(new int[]{x, y, dist[x][y], cnt + 1});
                        }
                    }
                }
            }
        }
        return dist;
    }

}
