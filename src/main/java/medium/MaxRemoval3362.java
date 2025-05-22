package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 零数组变换 III
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和一个二维数组 queries ，其中 queries[i] = [li, ri] 。
 * 每一个 queries[i] 表示对于 nums 的以下操作：
 * 将 nums 中下标在范围 [li, ri] 之间的每一个元素 最多 减少 1 。
 * 坐标范围内每一个元素减少的值相互 独立 。
 * 零数组 指的是一个数组里所有元素都等于 0 。
 * 请你返回 最多 可以从 queries 中删除多少个元素，使得 queries 中剩下的元素仍然能将 nums 变为一个 零数组 。如果无法将 nums 变为一个 零数组 ，返回 -1 。
 *
 * @author jd95288
 * @date 2025-05-22 23:02
 */
public class MaxRemoval3362 {

    public int maxRemoval(int[] nums, int[][] queries) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        int n = nums.length;
        int[] diff = new int[n + 1];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        int num = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            num += diff[i];
            while (k < queries.length && queries[k][0] <= i) {
                q.offer(queries[k++][1]);
            }
            while (!q.isEmpty() && q.peek() >= i && num > 0) {
                diff[q.poll() + 1]++;
                num--;
            }
            if (num > 0) {
                return -1;
            }
        }
        return q.size();
    }

}
