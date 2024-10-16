package easy;

import java.util.Arrays;

/**
 * 最小元素和最大元素的最小平均值
 * <p>
 * 你有一个初始为空的浮点数数组 averages。另给你一个包含 n 个整数的数组 nums，其中 n 为偶数。
 * 你需要重复以下步骤 n / 2 次：
 * 从 nums 中移除 最小 的元素 minElement 和 最大 的元素 maxElement。
 * 将 (minElement + maxElement) / 2 加入到 averages 中。
 * 返回 averages 中的 最小 元素。
 *
 * @author jd95288
 * @date 2024-10-16 8:49
 */
public class MinimumAverage3194 {

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int end = n / 2;
        n = n - 1;
        double res = Double.MAX_VALUE;
        for (int i = 0; i < end; i++) {
            res = Math.min(res, (nums[i] + nums[n - i]) / 2.0);
        }
        return res;
    }
}
