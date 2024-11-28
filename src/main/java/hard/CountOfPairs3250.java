package hard;

import java.util.Arrays;

/**
 * 单调数组对的数目I
 * <p>
 * 有一个长度为 n 正整数数组 nums，可以将其拆成两个数组 arr1 arr2，
 * 使之满足 arr1[i] + arr2[i] == nums[i]。问 有多少种拆分方法使得 arr1 非递减 且 arr2 非递增。
 *
 * @author jd95288
 * @date 2024-11-28 10:36
 */
public class CountOfPairs3250 {

    public static int MOD = 1000000007;

    public int countOfPairs(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[][] mem = new int[n + 1][51];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i <= nums[0]; i++) {
            res = (res + dfs(nums, 1, i, mem)) % MOD;
        }
        return res;
    }

    public int dfs(int[] nums, int i, int prev, int[][] mem) {
        int n = nums.length;
        if (i == n) {
            return 1;
        }
        int lowerBound = Math.max(prev, nums[i] - nums[i - 1] + prev);
        int next = i + 1;
        int res = 0;
        for (int j = lowerBound; j <= nums[i]; j++) {
            if (mem[next][j] == -1) {
                mem[next][j] = dfs(nums, next, j, mem) % MOD;
            }
            res = (res + mem[next][j]) % MOD;
        }
        return res;
    }

}
