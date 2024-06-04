package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在带权树网络中统计可连接服务器对数目
 * <p>
 * 给你一棵无根带权树，树中总共有 n 个节点，分别表示 n 个服务器，服务器从 0 到 n - 1 编号。
 * 同时给你一个数组 edges ，其中 edges[i] = [ai, bi, weighti] 表示节点 ai 和 bi 之间有一条双向边，边的权值为 weighti 。
 * 再给你一个整数 signalSpeed 。
 * 如果两个服务器 a ，b 和 c 满足以下条件，那么我们称服务器 a 和 b 是通过服务器 c 可连接的 ：
 * a < b ，a != c 且 b != c 。
 * 从 c 到 a 的距离是可以被 signalSpeed 整除的。
 * 从 c 到 b 的距离是可以被 signalSpeed 整除的。
 * 从 c 到 b 的路径与从 c 到 a 的路径没有任何公共边。
 * 请你返回一个长度为 n 的整数数组 count ，其中 count[i] 表示通过服务器 i 可连接 的服务器对的 数目 。
 *
 * @author jd95288
 * @date 2024-06-04 8:41
 */
public class CountPairsOfConnectableServers3067 {

    private List<int[]>[] g;
    private int speed;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length;
        g = new List[n + 1];
        speed = signalSpeed;
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            g[edges[i][0]].add(new int[]{edges[i][1], edges[i][2]});
            g[edges[i][1]].add(new int[]{edges[i][0], edges[i][2]});
        }
        for (int i = 0; i <= n; i++) {
            int pre = 0;
            if (g[i].size() == 1) {
                continue;
            }
            for (int j = 0; j < g[i].size(); j++) {
                int cnt = dfs(g[i].get(j)[0], i, g[i].get(j)[1]);
                res[i] += pre * cnt;
                pre += cnt;
            }
        }
        return res;
    }

    public int dfs(int root, int parent, int path) {
        int cnt = path % speed == 0 ? 1 : 0;
        if (g[root].size() == 1 && parent != -1) {
            return cnt;
        }
        for (int[] child : g[root]) {
            if (child[0] == parent) {
                continue;
            }
            cnt += dfs(child[0], root, path + child[1]);
        }
        return cnt;
    }

}
