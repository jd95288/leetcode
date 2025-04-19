package medium;

import java.util.Arrays;

/**
 * 统计公平数对的数目
 * <p>
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
 * 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
 * 0 <= i < j < n，且
 * lower <= nums[i] + nums[j] <= upper
 *
 * @author jd95288
 * @date 2025-04-19 21:41
 */
public class CountFairPairs2563 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0L;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int l = lowerBound(i + 1, n - 1, lower - nums[i], nums);
            int r = upperBound(i + 1, n - 1, upper - nums[i], nums);
            res += r - l + 1;
        }
        return res;
    }

    public int lowerBound(int left, int right, int target, int[] nums) {
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return left;
    }

    public int upperBound(int left, int right, int target, int[] nums) {
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return right;
    }

}
