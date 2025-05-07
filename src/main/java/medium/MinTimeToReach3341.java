package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 到达最后一个房间的最少时间 I
 * <p>
 * 有一个地窖，地窖中有 n x m 个房间，它们呈网格状排布。
 * 给你一个大小为 n x m 的二维数组 moveTime ，其中 moveTime[i][j] 表示在这个时刻 以后 你才可以 开始 往这个房间 移动 。你在时刻 t = 0 时从房间 (0, 0) 出发，每次可以移动到 相邻 的一个房间。在 相邻 房间之间移动需要的时间为 1 秒。
 * 请你返回到达房间 (n - 1, m - 1) 所需要的 最少 时间。
 * 如果两个房间有一条公共边（可以是水平的也可以是竖直的），那么我们称这两个房间是 相邻 的。
 *
 * @author jd95288
 * @date 2025-05-07 8:50
 */
public class MinTimeToReach3341 {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = dijkstra(moveTime);
        return dist[n - 1][m - 1];
    }

    private int[][] dijkstra(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        int[][] dist = new int[n][m];
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1], waitTime = cur[2];
            if (waitTime > dist[i][j]) {
                continue;
            }
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x < n && x >= 0 && y >= 0 && y < m && dist[x][y] > Math.max(dist[i][j], g[x][y]) + 1) {
                    dist[x][y] = Math.max(dist[i][j], g[x][y]) + 1;
                    q.offer(new int[]{x, y, dist[x][y]});
                }
            }
        }
        return dist;
    }

}
