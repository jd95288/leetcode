package hard;

import java.util.*;

/**
 * 连接两棵树后最大目标节点数目 II
 * <p>
 * 有两棵 无向 树，分别有 n 和 m 个树节点。两棵树中的节点编号分别为[0, n - 1] 和 [0, m - 1] 中的整数。
 * 给你两个二维整数 edges1 和 edges2 ，长度分别为 n - 1 和 m - 1 ，
 * 其中 edges1[i] = [ai, bi] 表示第一棵树中节点 ai 和 bi 之间有一条边，edges2[i] = [ui, vi] 表示第二棵树中节点 ui 和 vi 之间有一条边。
 * 如果节点 u 和节点 v 之间路径的边数是偶数，那么我们称节点 u 是节点 v 的 目标节点 。注意 ，一个节点一定是它自己的 目标节点 。
 * 请你返回一个长度为 n 的整数数组 answer ，answer[i] 表示将第一棵树中的一个节点与第二棵树中的一个节点连接一条边后，第一棵树中节点 i 的 目标节点 数目的 最大值 。
 * 注意 ，每个查询相互独立。意味着进行下一次查询之前，你需要先把刚添加的边给删掉。
 *
 * @author jd95288
 * @date 2025-05-29 23:50
 */
public class MaxTargetNodes3373 {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<Integer>[] g1 = new List[n];
        List<Integer>[] g2 = new List[m];
        Arrays.setAll(g1, x -> new ArrayList<>());
        Arrays.setAll(g2, x -> new ArrayList<>());
        for (int[] edge : edges1) {
            int a = edge[0];
            int b = edge[1];
            g1[a].add(b);
            g1[b].add(a);
        }
        for (int[] edge : edges2) {
            int a = edge[0];
            int b = edge[1];
            g2[a].add(b);
            g2[b].add(a);
        }
        Set<Integer>[] set1 = new HashSet[2];
        Arrays.setAll(set1, x -> new HashSet<>());
        int[] set2 = new int[]{0, 0};
        dfs(0, -1, g1, 0, set1);
        dfs(0, -1, g2, 0, set2);
        int max2 = Math.max(set2[0], set2[1]);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (set1[0].contains(i)) {
                res[i] = set1[0].size() + max2;
            } else {
                res[i] = set1[1].size() + max2;
            }
        }
        return res;
    }

    public void dfs(int cur, int parent, List<Integer>[] g, int flag, Set<Integer>[] set) {
        set[flag].add(cur);
        for (Integer next : g[cur]) {
            if (next == parent) {
                continue;
            }
            dfs(next, cur, g, flag ^ 1, set);
        }
    }

    public void dfs(int cur, int parent, List<Integer>[] g, int flag, int[] res) {
        res[flag]++;
        for (Integer next : g[cur]) {
            if (next == parent) {
                continue;
            }
            dfs(next, cur, g, flag ^ 1, res);
        }
    }
}
