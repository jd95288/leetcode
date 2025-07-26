package hard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从树中删除边的最小分数
 * <p>
 * 存在一棵无向连通树，树中有编号从 0 到 n - 1 的 n 个节点， 以及 n - 1 条边。
 * 给你一个下标从 0 开始的整数数组 nums ，长度为 n ，其中 nums[i] 表示第 i 个节点的值。
 * 另给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中存在一条位于节点 ai 和 bi 之间的边。
 * 删除树中两条 不同 的边以形成三个连通组件。对于一种删除边方案，定义如下步骤以计算其分数：
 * 分别获取三个组件 每个 组件中所有节点值的异或值。
 * 最大 异或值和 最小 异或值的 差值 就是这一种删除边方案的分数。
 * 例如，三个组件的节点值分别是：[4,5,7]、[1,9] 和 [3,3,3] 。
 * 三个异或值分别是 4 ^ 5 ^ 7 = 6、1 ^ 9 = 8 和 3 ^ 3 ^ 3 = 3 。
 * 最大异或值是 8 ，最小异或值是 3 ，分数是 8 - 3 = 5 。
 * 返回在给定树上执行任意删除边方案可能的 最小 分数。
 *
 * @author jd95288
 * @date 2025-07-24 8:46
 */
public class MinimumScore2322 {

    int res = Integer.MAX_VALUE;
    int allXor = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, x -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        for (int num : nums) {
            allXor ^= num;
        }
        dfs(0, -1, nums, g);
        return res;
    }

    public int dfs(int i, int p, int[] nums, List<Integer>[] g) {
        int val = nums[i];
        for (Integer next : g[i]) {
            if (next == p) {
                continue;
            }
            val ^= dfs(next, i, nums, g);
        }
        if (p != -1) {
            subDfs(p, i, p, val, allXor ^ val, nums, g);
        }
        return val;
    }

    public int subDfs(int i, int p, int anc, int firstXor, int subXor, int[] nums, List<Integer>[] g) {
        int val = nums[i];
        for (Integer next : g[i]) {
            if (next == p) {
                continue;
            }
            val ^= subDfs(next, i, anc, firstXor, subXor, nums, g);
        }
        if (i == anc) {
            return val;
        }
        int secondXor = subXor ^ val;
        int max = Math.max(Math.max(firstXor, secondXor), val);
        int min = Math.min(Math.min(firstXor, secondXor), val);
        res = Math.min(res, max - min);
        return val;
    }

}
