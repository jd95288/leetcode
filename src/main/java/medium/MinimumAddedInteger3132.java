package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 找出与数组相加的整数 II
 * <p>
 * 给你两个整数数组 nums1 和 nums2。
 * 从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 * 执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 * 返回能够实现数组相等的 最小 整数 x 。
 *
 * @author jd95288
 * @date 2024-08-09 0:30
 */
public class MinimumAddedInteger3132 {

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Map<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> set = new HashMap<>(nums1.length);
        for (int i : nums1) {
            set.merge(i, 1, Integer::sum);
        }
        for (int v2 : nums2) {
            for (int v1 : nums1) {
                map.merge(v2 - v1, 1, Integer::sum);
            }
        }
        int res = Integer.MAX_VALUE;
        here:
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Map<Integer, Integer> tmp = new HashMap<>(set);
            if (entry.getValue() >= n) {
                for (int i : nums2) {
                    if (tmp.get(i - entry.getKey()) == null || tmp.get(i - entry.getKey()) <= 0) {
                        continue here;
                    }
                    tmp.merge(i - entry.getKey(), -1, Integer::sum);
                }
                res = Math.min(res, entry.getKey());
            }
        }
        return res;
    }

}
