package medium;

/**
 * 搜索旋转排序数组
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * @author jd95288
 * @date 2024-08-17 22:13
 */
public class Search33 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (check(nums[mid], nums[0], target)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        if (left >= 0 && left < n) {
            if (nums[left] == target) {
                return left;
            }
        }
        return -1;
    }

    public boolean check(int midValue, int firstValue, int target) {
        if (target < firstValue) {
            if (midValue >= firstValue) {
                return true;
            } else {
                return midValue < target;
            }
        } else {
            if (midValue >= firstValue) {
                return midValue < target;
            } else {
                return false;
            }
        }
    }

}
