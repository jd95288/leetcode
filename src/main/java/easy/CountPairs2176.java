package easy;


/**
 * 统计数组中相等且可以被整除的数对
 * <p>
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，
 * 请你返回满足 0 <= i < j < n ，nums[i] == nums[j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目 。
 *
 * @author jd95288
 * @date 2025-04-17 0:09
 */
public class CountPairs2176 {

    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
