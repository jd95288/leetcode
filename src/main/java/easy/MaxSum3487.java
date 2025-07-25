package easy;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 删除后的最大子数组元素和
 * <p>
 * 给你一个整数数组 nums 。
 * 你可以从数组 nums 中删除任意数量的元素，但不能将其变为 空 数组。执行删除操作后，选出 nums 中满足下述条件的一个子数组：
 * 子数组中的所有元素 互不相同 。
 * 最大化 子数组的元素和。
 * 返回子数组的 最大元素和 。
 * 子数组 是数组的一个连续、非空 的元素序列。
 *
 * @author jd95288
 * @date 2025-07-25 8:55
 */
public class MaxSum3487 {

    public int maxSum(int[] nums) {
        int sum = Arrays.stream(nums).distinct().filter(x -> x > 0).sum();
        if (sum == 0){
            OptionalInt max = Arrays.stream(nums).max();
            return max.isPresent() ? max.getAsInt() : sum;
        }
        return sum;
    }

}
