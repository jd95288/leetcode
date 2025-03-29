package hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author jd95288
 * @date 2024-12-11 16:37
 */
public class Trap42 {

    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0, level;
        for (int i = 0; i < n; i++) {
            int right = height[i];
            while (!stack.isEmpty() && height[stack.peek()] <= right) {
                level = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                Integer l = stack.peek();
                int left = height[l];
                res += (Math.min(left, right) - level) * (i - l - 1);
            }
            stack.push(i);
        }
        return res;
    }

}
