package medium;

/**
 * 零数组变换 I
 * <p>
 * 给定一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri]。
 * 对于每个查询 queries[i]：
 * 在 nums 的下标范围 [li, ri] 内选择一个下标 子集。
 * 将选中的每个下标对应的元素值减 1。
 * 零数组 是指所有元素都等于 0 的数组。
 * 如果在按顺序处理所有查询后，可以将 nums 转换为 零数组 ，则返回 true，否则返回 false。
 *
 * @author jd95288
 * @date 2025-05-20 9:37
 */
public class IsZeroArray3355 {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        for (int[] query : queries) {
            diff[query[0]] -= 1;
            diff[query[1] + 1] += 1;
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
