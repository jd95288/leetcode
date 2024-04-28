package medium;

import java.util.Arrays;

/**
 * 组合总和 Ⅳ
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * 顺序不同的序列被视作不同的组合。
 *
 * @author jd95288
 * @date 2024-04-22 8:31
 */
public class CombinationSum377 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                dp[nums[i]] = 1;
            }
        }
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
