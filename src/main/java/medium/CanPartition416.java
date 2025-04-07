package medium;

import java.util.Arrays;

/**
 * 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @author jd95288
 * @date 2025-04-07 8:47
 */
public class CanPartition416 {

    int total;

    public boolean canPartition(int[] nums) {
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        }
        int[][] mem = new int[nums.length][total + 1];
        for (int[] m : mem) {
            Arrays.fill(m, -1);
        }
        return dfs(0, nums, 0, mem);
    }

    public boolean dfs(int index, int[] nums, int sum, int[][] mem) {
        if (index == nums.length) {
            return total == sum << 1;
        }
        if (mem[index][sum] != -1) {
            return mem[index][sum] == 1;
        }
        boolean res;
        res = dfs(index + 1, nums, sum, mem);
        if (!res) {
            res = dfs(index + 1, nums, sum + nums[index], mem);
        }
        mem[index][sum] = res ? 1 : 0;
        return res;
    }

}
