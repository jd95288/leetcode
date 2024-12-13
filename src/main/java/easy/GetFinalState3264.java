package easy;

import java.util.PriorityQueue;

/**
 * K 次乘运算后的最终数组 I
 * <p>
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 * 你需要对 nums 执行 k 次操作，每次操作中：
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * <p>
 * 请你返回执行完 k 次乘运算之后，最终的 nums 数组。
 *
 * @author jd95288
 * @date 2024-12-13 2:13
 */
public class GetFinalState3264 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            int compare = nums[a] - nums[b];
            if (compare != 0){
                return compare;
            }
            return a - b;
        });
        for (int i = 0; i < n; i++) {
            q.offer(i);
        }
        for (int i = 0; i < k; i++) {
            int index = q.poll();
            nums[index] *= multiplier;
            q.offer(index);
        }
        return nums;
    }

}
