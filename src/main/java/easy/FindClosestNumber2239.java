package easy;

/**
 * 找到最接近0的数字
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。
 *
 * @author jd95288
 * @date 2025-01-20 8:43
 */
public class FindClosestNumber2239 {

    public int findClosestNumber(int[] nums) {
        int res = nums[0];
        for (int num : nums) {
            int a = Math.abs(res);
            int b = Math.abs(num);
            if (a > b) {
                res = num;
            } else if (a == b) {
                res = Math.max(res, num);
            }
        }
        return res;
    }
}
