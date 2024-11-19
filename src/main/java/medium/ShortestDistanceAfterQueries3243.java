package medium;

import java.util.*;

/**
 * 新增道路查询后的最短距离 I
 * <p>
 * 有 n 个城市，刚开始每一个城市 i 有一条单项道路通向城市 i + 1，
 * 有一个二维数组 queries，queries[i] 表示增加一条从 queries[i][0] 到 queries[i][1] 的单项道路，
 * 返回 answer 数组，answer[i] 表示增加了 queries[i] 之后从城市 0 到城市 n - 1 的最短路径。
 *
 * @author jd95288
 * @date 2024-11-19 0:47
 */
public class ShortestDistanceAfterQueries3243 {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
            g[i].add(i + 1);
        }
        int ql = queries.length;
        int[] res = new int[ql];
        int[] visited = new int[n];
        for (int i = 0; i < ql; i++) {
            g[queries[i][0]].add(queries[i][1]);
            res[i] = bfs(g, i + 1, visited);
        }
        return res;
    }

    public int bfs(List<Integer>[] g, int k, int[] visited) {
        int n = g.length;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int res = 1; ; res++) {
            List<Integer> tmp = list;
            list = new ArrayList<>();
            for (Integer cur : tmp) {
                for (Integer next : g[cur]) {
                    if (next == n - 1) {
                        return res;
                    }
                    if (visited[next] != k) {
                        visited[next] = k;
                        list.add(next);
                    }
                }
            }
        }
    }

}
