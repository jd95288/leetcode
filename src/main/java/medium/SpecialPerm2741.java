package medium;

import java.util.Arrays;

/**
 * 特别的排列
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。
 * 如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列：
 * 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] == 0 。
 * 请你返回特别排列的总数目，由于答案可能很大，请将它对 10^9 + 7 取余 后返回。
 *
 * @author jd95288
 * @date 2024-06-26 0:09
 */
public class SpecialPerm2741 {

    private static final int MOD = 1000000007;

    public int specialPerm_v2(int[] nums) {
        int n = nums.length;
        long res = 0;
        int bitmap = (1 << n) - 1;
        int[][] mem = new int[bitmap][n];
        for (int[] m : mem) {
            Arrays.fill(m, -1);
        }
        for (int i = 0; i < n; i++) {
            res = (res + dfs_v2(nums, i, mem, bitmap ^ (1 << i))) % MOD;
        }
        return (int) res;
    }

    public int dfs_v2(int[] nums, int parentIndex, int[][] mem, int bitmap) {
        if (bitmap == 0) {
            return 1;
        }
        if (mem[bitmap][parentIndex] != -1) {
            return mem[bitmap][parentIndex];
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((bitmap >> i & 1) > 0 && (nums[parentIndex] % nums[i] == 0 || nums[i] % nums[parentIndex] == 0)) {
                res = (res + dfs_v2(nums, i, mem, bitmap ^ (1 << i))) % MOD;
            }
        }
        return mem[bitmap][parentIndex] = (int) res;
    }

}
