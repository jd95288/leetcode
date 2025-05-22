package medium;

/**
 * 零数组变换 II
 *
 * 给你一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri, vali]。
 * 每个 queries[i] 表示在 nums 上执行以下操作：
 * 将 nums 中 [li, ri] 范围内的每个下标对应元素的值 最多 减少 vali。
 * 每个下标的减少的数值可以独立选择。
 * 零数组 是指所有元素都等于 0 的数组。
 * 返回 k 可以取到的 最小非负 值，使得在 顺序 处理前 k 个查询后，nums 变成 零数组。如果不存在这样的 k，则返回 -1。
 *
 * @author jd95288
 * @date 2025-05-21 9:35
 */
public class MinZeroArray3356 {

    public int minZeroArray(int[] nums, int[][] queries) {
        int right = queries.length - 1;
        int left = -1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (check(nums, mid, queries)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return left == queries.length ? -1 : left + 1;
    }

    public boolean check(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        for (int i = 0; i <= k; i++) {
            int[] query = queries[i];
            int val = query[2];
            diff[query[0]] -= val;
            diff[query[1] + 1] += val;
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += diff[i];
            if (num > 0) {
                return false;
            }
        }
        return true;
    }

}
