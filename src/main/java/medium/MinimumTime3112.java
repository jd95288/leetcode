package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 访问消失节点的最少时间
 *
 * 给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间有一条需要 lengthi 单位时间通过的无向边。
 * 同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。
 * 注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。
 * 请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么 answer[i] 为 -1 。
 *
 * @author jd95288
 * @date 2024-07-18 0:20
 */
public class MinimumTime3112 {

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] g = new ArrayList[n];
        for (int[] edge : edges) {
            if (g[edge[0]] == null) {
                g[edge[0]] = new ArrayList<>();
            }
            if (g[edge[1]] == null) {
                g[edge[1]] = new ArrayList<>();
            }
            g[edge[0]].add(new int[]{edge[1], edge[2]});
            g[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] dis = new int[n];
        dis[0] = 0;
        for (int i = 1; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cur = node[0];
            if (g[cur] == null || node[1] > dis[cur]){
                continue;
            }
            for (int[] item : g[cur]) {
                int next = item[0];
                if (next == cur){
                    continue;
                }
                int cost = item[1];
                int totalCost = dis[cur] + cost;
                if (dis[next] <= totalCost || (cur != 0 && disappear[cur] <= dis[cur])) {
                    continue;
                }
                if (totalCost < disappear[next]) {
                    dis[next] = totalCost;
                    q.offer(new int[]{next, totalCost});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dis[i] >= disappear[i]) {
                dis[i] = -1;
            }
        }
        return dis;
    }

}
