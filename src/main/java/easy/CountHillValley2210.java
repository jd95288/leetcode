package easy;

/**
 * 统计数组中峰和谷的数量
 *
 * 给你一个下标从 0 开始的整数数组 nums 。如果两侧距 i 最近的不相等邻居的值均小于 nums[i] ，
 * 则下标 i 是 nums 中，某个峰的一部分。类似地，如果两侧距 i 最近的不相等邻居的值均大于 nums[i] ，
 * 则下标 i 是 nums 中某个谷的一部分。对于相邻下标 i 和 j ，如果 nums[i] == nums[j] ， 则认为这两下标属于 同一个 峰或谷。
 * 注意，要使某个下标所做峰或谷的一部分，那么它左右两侧必须 都 存在不相等邻居。
 * 返回 nums 中峰和谷的数量。
 *
 * @author jd95288
 * @date 2025-07-27 23:31
 */
public class CountHillValley2210 {

    public int countHillValley(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int r = i + 1;
            while (r < n - 1 && nums[r] == nums[i]){
                r++;
            }
            if (nums[i] > nums[i - 1] && nums[r - 1] > nums[r]){
                res++;
            }
            if (nums[i] < nums[i - 1] && nums[r - 1] < nums[r]){
                res++;
            }
        }
        return res;
    }
}
