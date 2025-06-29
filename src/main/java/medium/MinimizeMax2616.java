package medium;

import java.util.Arrays;

/**
 * 最小化数对的最大差值
 *
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 p 。请你从 nums 中找到 p 个下标对，每个下标对对应数值取差值，你需要使得这 p 个差值的 最大值 最小。同时，你需要确保每个下标在这 p 个下标对中最多出现一次。
 * 对于一个下标对 i 和 j ，这一对的差值为 |nums[i] - nums[j]| ，其中 |x| 表示 x 的 绝对值 。
 * 请你返回 p 个下标对对应数值 最大差值 的 最小值 。
 *
 * @author jd95288
 * @date 2025-06-13 0:09
 */
public class MinimizeMax2616 {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int r = 1000000000;
        int l = 0;
        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (check(nums, p, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = l + (r - l) / 2;
        }
        return l;
    }

    public boolean check(int[] nums, int p, int cur) {
        int n = nums.length;
        for (int i = 1; i < n && p > 0; i++) {
            if (nums[i] - nums[i - 1] <= cur) {
                i++;
                p--;
            }
        }
        return p == 0;
    }

}
