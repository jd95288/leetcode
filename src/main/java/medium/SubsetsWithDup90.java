package medium;

import java.util.*;

/**
 * 子集 II
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * @author jd95288
 * @date 2025-02-05 9:09
 */
public class SubsetsWithDup90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, nums, set, subset, res);
        return res;
    }

    public void dfs(int index, int[] nums, Set<String> set, List<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(index + 1, nums, set, subset, res);
        subset.remove(subset.size() - 1);
        index++;
        while (index < nums.length && nums[index] == nums[index - 1]) {
            index++;
        }
        dfs(index, nums, set, subset, res);
    }

}
