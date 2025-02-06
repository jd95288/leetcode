package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * @author jd95288
 * @date 2025-02-06 8:41
 */
public class PermuteUnique47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<Integer> path = Arrays.asList(new Integer[n]);
        dfs(0, nums, visited, path, res);
        return res;
    }

    public void dfs(int index, int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> res) {
        int n = nums.length;
        if (index == n) {
            List<Integer> permute = new ArrayList<>(path);
            res.add(permute);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            path.set(index, nums[i]);
            dfs(index + 1, nums, visited, path, res);
            visited[i] = false;
        }
    }

}
