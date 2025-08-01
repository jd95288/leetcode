package medium;

import java.util.Arrays;

/**
 * 按位与最大的最长子数组
 *
 * 给你一个长度为 n 的整数数组 nums 。
 * 考虑 nums 中进行 按位与（bitwise AND）运算得到的值 最大 的 非空 子数组。
 * 换句话说，令 k 是 nums 任意 子数组执行按位与运算所能得到的最大值。那么，只需要考虑那些执行一次按位与运算后等于 k 的子数组。
 * 返回满足要求的 最长 子数组的长度。
 * 数组的按位与就是对数组中的所有数字进行按位与运算。
 * 子数组 是数组中的一个连续元素序列。
 *
 * @author jd95288
 * @date 2025-07-30 10:28
 */
public class LongestSubarray2419 {

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int res = 1;
        int i = 0;
        while (i < n){
            int l = 0;
            while (i < n && nums[i++] == max){
                l++;
            }
            res = Math.max(res, l);
        }
        return res;
    }
}
