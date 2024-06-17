package medium;

/**
 * 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @author jd95288
 * @date 2024-06-16 10:57
 */
public class Rob198 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (n > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] += Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[n - 1];
    }
}
