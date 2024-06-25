package medium;

import java.util.Arrays;

/**
 * 下一个更大元素 II
 * <p>
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），
 * 返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * @author jd95288
 * @date 2024-06-24 0:18
 */
public class NextGreaterElements503 {

    public int[] nextGreaterElements_v4(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < 2 * n - 1; i++) {
            int index = i % n;
            while (top > -1 && nums[stack[top]] < nums[index]) {
                res[stack[top--]] = nums[index];
            }
            if (i < n) {
                stack[++top] = index;
            }
        }
        return res;
    }
}
