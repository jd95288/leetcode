package easy;

import java.util.Arrays;

/**
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @author jd95288
 * @date 2024-08-11 23:16
 */
public class SearchInsert35 {
    public int searchInsert(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);
        return res < 0 ? -res - 1 : res;
    }
}
