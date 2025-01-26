package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 *
 * @author jd95288
 * @date 2025-01-26 15:24
 */
public class CombinationSum40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 需要排序
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, 0, target, candidates, path, res);
        return res;
    }

    public void dfs(int index, int sum, int target, int[] candidates, List<Integer> path, List<List<Integer>> res) {
        if (sum == target) {
            List<Integer> tmp = new ArrayList<>(path);
            res.add(tmp);
            return;
        }
        if (index == candidates.length || sum > target) {
            return;
        }
        int cur = candidates[index];
        path.add(cur);
        dfs(index + 1, sum + cur, target, candidates, path, res);
        path.remove(path.size() - 1);
        index++;
        while (index < candidates.length && cur == candidates[index]) {
            index++;
        }
        dfs(index, sum, target, candidates, path, res);
    }
}
