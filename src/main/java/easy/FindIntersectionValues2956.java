package easy;


/**
 * 找到两个数组中的公共元素
 * <p>
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。
 * 请你计算以下两个数值：
 * 统计 0 <= i < n 中的下标 i ，满足 nums1[i] 在 nums2 中 至少 出现了一次。
 * 统计 0 <= i < m 中的下标 i ，满足 nums2[i] 在 nums1 中 至少 出现了一次。
 * 请你返回一个长度为 2 的整数数组 answer ，按顺序 分别为以上两个数值。
 *
 * @author jd95288
 * @date 2024-07-16 0:14
 */
public class FindIntersectionValues2956 {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] count1 = new int[101];
        for (int i : nums1) {
            count1[i]++;
        }
        int a = 0, b = 0;
        for (int i : nums2) {
            if (count1[i] != 0) {
                b++;
                a += count1[i] == -1 ? 0 : count1[i];
                count1[i] = -1;
            }
        }
        return new int[]{a, b};
    }

}
