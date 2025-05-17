package medium;

import java.util.Arrays;

/**
 * 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * @author jd95288
 * @date 2025-05-17 15:35
 */
public class SortColors75 {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int pivot = 1;
        int a = 0, i = 0, b = n - 1;
        while (i <= b) {
            if (nums[i] < pivot) {
                swap(nums, a, i);
                a++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, b);
                b--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
