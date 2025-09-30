package medium;

/**
 * 数组的三角和
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums ，其中 nums[i] 是 0 到 9 之间（两者都包含）的一个数字。
 * nums 的 三角和 是执行以下操作以后最后剩下元素的值：
 * 1. nums 初始包含 n 个元素。如果 n == 1 ，终止 操作。否则，创建 一个新的下标从 0 开始的长度为 n - 1 的整数数组 newNums 。
 * 2. 对于满足 0 <= i < n - 1 的下标 i ，newNums[i] 赋值 为 (nums[i] + nums[i+1]) % 10 ，% 表示取余运算。
 * 3. 将 newNums 替换 数组 nums 。
 * 4. 从步骤 1 开始 重复 整个过程。
 * 请你返回 nums 的三角和。
 *
 * @author jd95288
 * @date 2025-09-30 8:44
 */
public class TriangularSum2221 {

    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}
