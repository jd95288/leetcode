package easy;

/**
 * 数组元素和与数字和的绝对差
 *
 * 给你一个正整数数组 nums 。
 *
 * 元素和 是 nums 中的所有元素相加求和。
 * 数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
 *
 * 返回 元素和 与 数字和 的绝对差。
 * 注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
 *
 * @author jd95288
 * @date 2024-09-26 8:45
 */
public class DifferenceOfSum2535 {

    public int differenceOfSum(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += num;
            while (num > 0) {
                res -= num % 10;
                num /= 10;
            }
        }
        return res;
    }

}
