package hard;


import java.util.*;

/**
 * 收集所有金币可获得的最大积分
 * <p>
 * 有一棵由 n 个节点组成的无向树，以 0  为根节点，节点编号从 0 到 n - 1 。给你一个长度为 n - 1 的二维 整数 数组 edges ，其中 edges[i] = [ai, bi] 表示在树上的节点 ai 和 bi 之间存在一条边。另给你一个下标从 0 开始、长度为 n 的数组 coins 和一个整数 k ，其中 coins[i] 表示节点 i 处的金币数量。
 * 从根节点开始，你必须收集所有金币。要想收集节点上的金币，必须先收集该节点的祖先节点上的金币。
 * 节点 i 上的金币可以用下述方法之一进行收集：
 * - 收集所有金币，得到共计 coins[i] - k 点积分。如果 coins[i] - k 是负数，你将会失去 abs(coins[i] - k) 点积分。
 * - 收集所有金币，得到共计 floor(coins[i] / 2) 点积分。如果采用这种方法，节点 i 子树中所有节点 j 的金币数 coins[j] 将会减少至 floor(coins[j] / 2) 。
 * 返回收集 所有 树节点的金币之后可以获得的最大积分。
 *
 * @author jd95288
 * @date 2025-01-23 10:20
 */
public class MaximumPoints2920 {

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            g[from].add(to);
            g[to].add(from);
        }
        List<List<Integer>> depthNodes = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        depthNodes.add(l);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Integer from = q.poll();
                for (Integer to : g[from]) {
                    list.add(to);
                    g[to].removeIf(next -> next.equals(from));
                }
            }
            if (list.size() > 0) {
                depthNodes.add(list);
                q.addAll(list);
            }
        }
        int[][] dp = new int[n][15];
        int depth = depthNodes.size();
        for (Integer leaf : depthNodes.get(depth - 1)) {
            for (int t = 0; t < 14; t++) {
                dp[leaf][t] = Math.max((coins[leaf] >> t) - k, (coins[leaf] >> (t + 1)));
            }
        }
        for (int d = depth - 2; d >= 0; d--) {
            List<Integer> nodes = depthNodes.get(d);
            for (Integer cur : nodes) {
                for (int t = 0; t < 14; t++) {
                    int sum0 = 0;
                    int sum1 = 0;
                    for (Integer child : g[cur]) {
                        sum0 += dp[child][t];
                        sum1 += dp[child][t + 1];
                    }
                    dp[cur][t] = Math.max(sum0 + (coins[cur] >> t) - k, sum1 + (coins[cur] >> (t + 1)));
                }
            }
        }
        return dp[0][0];
    }

}
