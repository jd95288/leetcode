package medium;

/**
 * 袋子里最少数目的球
 * <p>
 * 给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
 * <p>
 * 你可以进行如下操作至多 maxOperations 次：
 * 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
 * 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
 * <p>
 * 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
 * 请你返回进行上述操作后的最小开销。
 *
 * @author jd95288
 * @date 2025-02-12 0:03
 */
public class MinimumSize1760 {

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 1000000000;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (check(nums, mid, maxOperations)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return left;
    }

    public boolean check(int[] nums, int mid, int maxOperations) {
        for (int num : nums) {
            maxOperations -= (num - 1) / mid;
            if (maxOperations < 0) {
                return false;
            }
        }
        return true;
    }

}
