package hard;

import java.util.PriorityQueue;

/**
 * 删除元素后和的最小差值
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums ，它包含 3 * n 个元素。
 * 你可以从 nums 中删除 恰好 n 个元素，剩下的 2 * n 个元素将会被分成两个 相同大小 的部分。
 * 前面 n 个元素属于第一部分，它们的和记为 sumfirst 。
 * 后面 n 个元素属于第二部分，它们的和记为 sumsecond 。
 * 两部分和的 差值 记为 sumfirst - sumsecond 。
 * 比方说，sumfirst = 3 且 sumsecond = 2 ，它们的差值为 1 。
 * 再比方，sumfirst = 2 且 sumsecond = 3 ，它们的差值为 -1 。
 * 请你返回删除 n 个元素之后，剩下两部分和的 差值的最小值 是多少。
 *
 * @author jd95288
 * @date 2025-07-18 8:43
 */
public class MinimumDifference2163 {

    public long minimumDifference(int[] nums) {
        int l = nums.length;
        int n = l / 3;
        long[] suffix = new long[l + 1];
        long[] prefix = new long[l + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
            suffix[l - i] = suffix[l - i + 1] + nums[l - i];
        }
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < 2 * n; i++) {
            left.add(nums[i]);
            if (left.size() > n) {
                Integer num = left.poll();
                prefix[i + 1] = prefix[i] + nums[i] - num;
            }
        }
        for (int i = l - 1; i >= n; i--) {
            right.add(nums[i]);
            if (right.size() > n) {
                Integer num = right.poll();
                suffix[i] = suffix[i + 1] + nums[i] - num;
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = n; i <= 2 * n; i++) {
            res = Math.min(res, prefix[i] - suffix[i]);
        }
        return res;
    }

}
