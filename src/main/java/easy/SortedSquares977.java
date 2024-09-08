package easy;

/**
 * 有序数组的平方
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * @author jd95288
 * @date 2024-09-08 20:40
 */
public class SortedSquares977 {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int top = -1;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = - nums[i];
                top++;
            } else {
                while (top >= 0 && nums[i] >= nums[top]) {
                    res[j++] = nums[top] * nums[top];
                    top--;
                }
                res[j++] = nums[i] * nums[i];
            }
        }
        while (top >= 0) {
            res[j++] = nums[top] * nums[top];
            top--;
        }
        return res;
    }

}
