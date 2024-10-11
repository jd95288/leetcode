package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 优质数对的总数II
 * <p>
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 * 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
 * 返回 优质数对 的总数。
 *
 * @author jd95288
 * @date 2024-10-11 8:40
 */
public class NumberOfPairs3164 {

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        Map<Integer, Integer> map2 = new HashMap<>(nums2.length);
        int max1 = 0;
        for (int num : nums1) {
            map1.merge(num, 1, Integer::sum);
            max1 = Math.max(max1, num);
        }
        for (int num : nums2) {
            map2.merge(num, 1, Integer::sum);
        }
        long res = 0L;
        for (int num : map2.keySet()) {
            int multiple = num * k;
            for (int i = multiple; i <= max1; i += multiple) {
                if (map1.containsKey(i)) {
                    res += (long) map1.get(i) * map2.get(num);
                }
            }
        }
        return res;
    }

}
