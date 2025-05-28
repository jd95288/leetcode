package medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 连接两棵树后最大目标节点数目 I
 * <p>
 * 有两棵 无向 树，分别有 n 和 m 个树节点。两棵树中的节点编号分别为[0, n - 1] 和 [0, m - 1] 中的整数。
 * 给你两个二维整数 edges1 和 edges2 ，长度分别为 n - 1 和 m - 1 ，其中 edges1[i] = [ai, bi] 表示第一棵树中节点 ai 和 bi 之间有一条边，edges2[i] = [ui, vi] 表示第二棵树中节点 ui 和 vi 之间有一条边。同时给你一个整数 k 。
 * 如果节点 u 和节点 v 之间路径的边数小于等于 k ，那么我们称节点 u 是节点 v 的 目标节点 。注意 ，一个节点一定是它自己的 目标节点 。
 * 请你返回一个长度为 n 的整数数组 answer ，answer[i] 表示将第一棵树中的一个节点与第二棵树中的一个节点连接一条边后，第一棵树中节点 i 的 目标节点 数目的 最大值 。
 * 注意 ，每个查询相互独立。意味着进行下一次查询之前，你需要先把刚添加的边给删掉。
 *
 * @author jd95288
 * @date 2025-05-28 23:36
 */
public class MaxTargetNodes3372 {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<Integer>[] g1 = new List[n];
        List<Integer>[] g2 = new List[m];
        Arrays.setAll(g1, x -> new ArrayList<>());
        Arrays.setAll(g2, x -> new ArrayList<>());
        for (int[] edge1 : edges1) {
            int a = edge1[0];
            int b = edge1[1];
            g1[a].add(b);
            g1[b].add(a);
        }
        for (int[] edge2 : edges2) {
            int a = edge2[0];
            int b = edge2[1];
            g2[a].add(b);
            g2[b].add(a);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dfs(i, -1, g2, 0, k - 1));
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(i, -1, g1, 0, k) + (k == 0 ? 0 : max);
        }
        return res;
    }

    public int dfs(int cur, int parent, List<Integer>[] g, int cnt, int k) {
        if (cnt >= k) {
            return 1;
        }
        int res = 0;
        for (Integer next : g[cur]) {
            if (next == parent) {
                continue;
            }
            res += dfs(next, cur, g, cnt + 1, k);
        }
        return res + 1;
    }

}
