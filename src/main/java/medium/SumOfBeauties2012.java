package medium;


/**
 * 数组美丽值求和
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
 * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
 * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
 * 0，如果上述条件全部不满足
 * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
 *
 * @author jd95288
 * @date 2025-03-11 8:48
 */
public class SumOfBeauties2012 {

    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        suffix[n - 1] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], nums[i - 1]);
            suffix[n - 1 - i] = Math.min(suffix[n - i], nums[n - i]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > prefix[i] && nums[i] < suffix[i]) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res++;
            }
        }
        return res;
    }

}
