package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找到离给定两个节点最近的节点
 * <p>
 * 给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，每个节点 至多 有一条出边。
 * 有向图用大小为 n 下标从 0 开始的数组 edges 表示，表示节点 i 有一条有向边指向 edges[i] 。如果节点 i 没有出边，那么 edges[i] == -1 。
 * 同时给你两个节点 node1 和 node2 。
 * 请你返回一个从 node1 和 node2 都能到达节点的编号，使节点 node1 和节点 node2 到这个节点的距离 较大值最小化。如果有多个答案，请返回 最小 的节点编号。如果答案不存在，返回 -1 。
 * 注意 edges 可能包含环。
 *
 * @author jd95288
 * @date 2025-05-30 0:44
 */
public class ClosestMeetingNode2359 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        return dfs(node1, node2, edges, new HashSet<>(), new HashSet<>());
    }

    public int dfs(int cur1, int cur2, int[] edges, Set<Integer> set1, Set<Integer> set2) {
        if (set1.contains(cur2) && set2.contains(cur1) || cur1 == cur2) {
            return Math.min(cur1, cur2);
        } else if (set1.contains(cur2)) {
            return cur2;
        } else if (set2.contains(cur1)) {
            return cur1;
        }
        if (cur1 != -1) {
            set1.add(cur1);
        }
        if (cur2 != -1) {
            set2.add(cur2);
        }
        if (cur1 != -1 && !set1.contains(edges[cur1])) {
            return dfs(edges[cur1], cur2 == -1 ? -1 : edges[cur2], edges, set1, set2);
        } else if (cur2 != -1 && !set2.contains(edges[cur2])) {
            return dfs(cur1 == -1 ? -1 : edges[cur1], edges[cur2], edges, set1, set2);
        }
        return -1;
    }

}
