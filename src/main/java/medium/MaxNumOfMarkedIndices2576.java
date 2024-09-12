package medium;

import java.util.Arrays;

/**
 * 求出最多标记下标
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 一开始，所有下标都没有被标记。你可以执行以下操作任意次：
 * 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
 * 请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
 *
 * @author jd95288
 * @date 2024-09-12 9:14
 */
public class MaxNumOfMarkedIndices2576 {

    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int rs = (n + 1) / 2;
        int l = 0;
        for (int r = rs; r < n; r++) {
            if (nums[l] * 2 <= nums[r]) {
                l++;
            }
        }
        return 2 * l;
    }

}
