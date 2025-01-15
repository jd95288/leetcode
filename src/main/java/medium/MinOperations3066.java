package medium;

import java.util.PriorityQueue;

/**
 * 超过阈值的最少操作数II
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 一次操作中，你将执行：
 * - 选择 nums 中最小的两个整数 x 和 y 。
 * - 将 x 和 y 从 nums 中删除。
 * - 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。
 * 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。
 * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
 *
 * @author jd95288
 * @date 2025-01-14 8:51
 */
public class MinOperations3066 {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int num : nums) {
            q.offer((long) num);
        }
        int res = 0;
        while (q.size() >= 2) {
            Long a = q.poll();
            Long b = q.poll();
            if (a >= k) {
                break;
            }
            q.offer(a * 2L + b);
            res++;
        }
        return res;
    }
}
