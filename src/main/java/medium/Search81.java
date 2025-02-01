package medium;

/**
 * 搜索旋转排序数组 II
 * <p>
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * 你必须尽可能减少整个操作步骤。
 *
 * @author jd95288
 * @date 2025-02-01 14:33
 */
public class Search81 {

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (right > 0 && nums[left] == nums[right]) {
            right--;
        }
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
            return nums[left] == target;
        }
        return false;
    }

    /**
     * 返回 true left 左移
     * 否则 right 右移
     */
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
