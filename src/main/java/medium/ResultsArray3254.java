package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 长度为 K 的子数组的能量值 I
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
 * 一个数组的 能量值 定义为：
 * 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
 * 否则为 -1 。
 * 你需要求出 nums 中所有长度为 k 的 子数组 的能量值。
 * 请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
 *
 * @author jd95288
 * @date 2024-11-06 5:50
 */
public class ResultsArray3254 {

    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) {
            return nums;
        }
        int[] res = new int[n - k + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int l = 0, i = 0;
        for (int r = 1; r < n; ) {
            while (r - l < k) {
                int prev = r - 1;
                if (nums[r] - nums[prev] != 1) {
                    q.offer(prev);
                }
                r++;
            }
            if (q.isEmpty()) {
                res[i++] = nums[r - 1];
            } else {
                res[i++] = -1;
            }
            if (!q.isEmpty() && l == q.peek()) {
                q.poll();
            }
            l++;
        }
        return res;
    }

}
