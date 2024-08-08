package easy;

/**
 * 找出与数组相加的整数 I
 * <p>
 * 给你两个长度相等的数组 nums1 和 nums2。
 * 数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 * 在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 * 返回整数 x 。
 *
 * @author jd95288
 * @date 2024-08-08 9:11
 */
public class AddedInteger3131 {
    public int addedInteger(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int max1 = nums1[0];
        int max2 = nums2[0];
        for (int i = 1; i < n; i++) {
            if (max1 < nums1[i]) {
                max1 = nums1[i];
            }
            if (max2 < nums2[i]) {
                max2 = nums2[i];
            }
        }
        return max2 - max1;
    }
}
