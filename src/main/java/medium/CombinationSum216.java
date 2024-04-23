package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * @author jd95288
 * @date 2024-04-21 20:44
 */
public class CombinationSum216 {

    public List<List<Integer>> combinationSum3_v1(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= 9; i++) {
            dfs(k - 1, i, n, q, res);
        }
        return res;
    }

    public void dfs(int k, int root, int target, Deque<Integer> q, List<List<Integer>> res) {
        if (k < 0 || target < 0) {
            return;
        }
        if (target == root && k == 0) {
            q.offer(root);
            res.add(new ArrayList<>(q));
            q.pollLast();
            return;
        }
        q.offer(root);
        for (int i = root + 1; i <= 9; i++) {
            dfs(k - 1, i, target - root, q, res);
        }
        q.pollLast();
    }

}
