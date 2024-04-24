package medium;

import java.util.*;

/**
 * 组合总和
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * @author jd95288
 * @date 2024-04-20 10:20
 */
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new List[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = new ArrayList<>();
        }
        for (int candidate : candidates) {
            if (candidate <= target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidate);
                dp[candidate].add(list);
            }
            for (int i = candidate; i <= target; i++) {
                for (List<Integer> lj : dp[i - candidate]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(candidate);
                    tmp.addAll(lj);
                    dp[i].add(tmp);
                }
            }
        }
        return dp[target];
    }

}
