package medium;


import java.util.ArrayList;
import java.util.List;

/**
 * 统计好节点的数目
 * <p>
 * 现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。
 * 给你一个长度为 n - 1 的二维整数数组 edges，其中 edges[i] = [ai, bi] 表示树中节点 ai 与节点 bi 之间存在一条边。
 * 如果一个节点的所有子节点为根的 子树 包含的节点数相同，则认为该节点是一个 好节点。
 * 返回给定树中 好节点 的数量。
 * 子树 指的是一个节点以及它所有后代节点构成的一棵树。
 *
 * @author jd95288
 * @date 2024-11-14 9:32
 */
public class CountGoodNodes3249 {
    int res = 0;
    List<Integer>[] g;

    public int countGoodNodes(int[][] edges) {
        g = new List[edges.length + 1];
        int n = g.length;
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            g[edges[i][0]].add(edges[i][1]);
            g[edges[i][1]].add(edges[i][0]);
        }
        dfs(-1, 0);
        return res;
    }

    public int dfs(int parent, int cur) {
        int num = 1;
        int prev = -1;
        boolean equal = true;
        for (Integer next : g[cur]) {
            if (next == parent) {
                continue;
            }
            int childNum = dfs(cur, next);
            if (prev != -1 && prev != childNum) {
                equal = false;
            }
            prev = childNum;
            num += childNum;
        }
        if (equal) {
            res++;
        }
        return num;
    }

}
