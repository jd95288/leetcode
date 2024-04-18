package medium;

import java.util.*;

/**
 * 有向无环图中一个节点的所有祖先
 * 给你一个正整数 n ，它表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1 （包括两者）。
 * 给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi] 表示图中一条从 fromi 到 toi 的单向边。
 * 请你返回一个数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序。
 * 如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点。
 *
 * @author jd95288
 * @date 2024-04-04 21:49
 */
public class GetAncestors2192 {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Set<Integer>[] dp = new TreeSet[n];
        List<List<Integer>> res = new ArrayList<>(n);
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] hasParent = new boolean[n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
            dp[i] = new TreeSet<>();
        }
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            hasParent[edge[1]] = true;
        }
        for (int i = 0; i < hasParent.length; i++) {
            if (!hasParent[i]) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            Integer from = q.poll();
            for (int i = 0; i < g[from].size(); i++) {
                dp[g[from].get(i)].addAll(dp[from]);
                dp[g[from].get(i)].add(from);
                if (!q.contains(g[from].get(i))) {
                    q.offer(g[from].get(i));
                }
            }
        }
        for (Set<Integer> integers : dp) {
            res.add(new ArrayList<>(integers));
        }
        return res;
    }
}
