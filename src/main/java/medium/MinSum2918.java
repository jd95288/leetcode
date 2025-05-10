package medium;

/**
 * 数组的最小相等和
 * <p>
 * 给你两个由正整数和 0 组成的数组 nums1 和 nums2 。
 * 你必须将两个数组中的 所有 0 替换为 严格 正整数，并且满足两个数组中所有元素的和 相等 。
 * 返回 最小 相等和 ，如果无法使两数组相等，则返回 -1 。
 *
 * @author jd95288
 * @date 2025-05-10 20:50
 */
public class MinSum2918 {

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums1) {
            sum1 += num;
            cnt1 += num == 0 ? 1 : 0;
        }
        for (int num : nums2) {
            sum2 += num;
            cnt2 += num == 0 ? 1 : 0;
        }
        if (cnt1 == 0 && cnt2 == 0) {
            return sum1 == sum2 ? sum1 : -1;
        } else if (cnt1 != 0 && cnt2 == 0) {
            return sum1 + cnt1 <= sum2 ? sum2 : -1;
        } else if (cnt1 == 0) {
            return sum1 >= sum2 + cnt2 ? sum1 : -1;
        } else {
            return Math.max(sum1 + cnt1, sum2 + cnt2);
        }
    }

}
