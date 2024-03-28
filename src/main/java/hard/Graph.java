package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 设计可以求最短路径的图类
 * 给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。
 * 图中的初始边用数组 edges 表示，
 * 其中 edges[i] = [fromi, toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为 edgeCosti 的边。
 * 请你实现一个 Graph 类：
 * Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。
 * addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost] 。
 * 数据保证添加这条边之前对应的两个节点之间没有有向边。
 * int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。
 * 如果路径不存在，返回 -1 。一条路径的代价是路径中所有边代价之和。
 *
 * @author jd95288
 * @date 2024-03-26 8:35
 */
public class Graph {

    private final ArrayList<int[]>[] g;

    private PriorityQueue<int[]> q;

    private int[] dp;

    private int n;

    public Graph(int n, int[][] edges) {
        g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            g[edges[i][0]].add(new int[]{edges[i][1], edges[i][2]});
        }
        q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        this.n = n;
    }

    public void addEdge(int[] edge) {
        g[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[node1] = 0;
        q.offer(new int[]{node1, 0});
        while (!q.isEmpty()) {
            int[] e = q.poll();
            for (int[] edge : g[e[0]]) {
                if (dp[e[0]] != Integer.MAX_VALUE && dp[e[0]] + edge[1] < dp[edge[0]]) {
                    dp[edge[0]] = dp[e[0]] + edge[1];
                    q.offer(edge);
                }
            }
        }
        return dp[node2] == Integer.MAX_VALUE ? -1 : dp[node2];
    }
}
