package easy;

/**
 * 半有序排列
 * <p>
 * 有一个数组 nums，求将最小值移动到第一个位置，最大值移动到最后一个位置需要的最小操作次数。
 *
 * @author jd95288
 * @date 2024-12-11 8:47
 */
public class SemiOrderedPermutation2717 {

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            } else if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int res = minIndex + n - maxIndex - 1;
        return minIndex > maxIndex ? res - 1 : res;
    }
}
