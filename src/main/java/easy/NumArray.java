package easy;

/**
 * 区域和检索 - 数组不可变
 * <p>
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
 * 包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 * @author jd95288
 * @date 2024-03-18 8:36
 */
public class NumArray {

    private final int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        NumArray main = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(main.sumRange(0, 2));
        System.out.println(main.sumRange(2, 5));
        System.out.println(main.sumRange(0, 5));
    }
}
