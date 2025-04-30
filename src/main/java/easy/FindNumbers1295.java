package easy;

/**
 * 统计位数为偶数的数字
 * <p>
 * 给你一个整数数组 nums，请你返回其中包含 偶数 个数位的数字的个数。
 *
 * @author jd95288
 * @date 2025-04-30 8:42
 */
public class FindNumbers1295 {

    public int findNumbers_v2(int[] nums) {
        int res = nums.length;
        for (int num : nums) {
            int cnt = 0;
            while (num > 0) {
                cnt++;
                num /= 10;
            }
            res -= cnt % 2;
        }
        return res;
    }

}
