package medium;


import java.util.*;

/**
 * 冗余连接
 * <p>
 * 树可以看成是一个连通且 无环 的 无向 图。
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。
 * 添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。
 * 图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。
 * 如果有多个答案，则返回数组 edges 中最后出现的那个。
 *
 * @author jd95288
 * @date 2024-10-27 16:34
 */
public class FindRedundantConnection684 {

    List<Integer>[] g;
    Set<Integer> loop;
    List<Integer> path;
    int start;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        loop = new HashSet<>(n);
        path = new ArrayList<>();
        dfs(0, 1);
        loop = new HashSet<>();
        for (int i = path.size() - 1; i >= 0; i--) {
            loop.add(path.get(i));
            if (start == path.get(i)) {
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (loop.contains(edges[i][0]) && loop.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return null;
    }

    private boolean dfs(int parent, int current) {
        for (Integer next : g[current]) {
            if (next == parent) {
                continue;
            }
            if (loop.contains(next)) {
                start = next;
                return true;
            } else {
                loop.add(next);
                path.add(next);
                if (dfs(current, next)) {
                    return true;
                }
                path.remove(path.size() - 1);
                loop.remove(next);
            }
        }
        return false;
    }
}
