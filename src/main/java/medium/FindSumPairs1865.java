package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出和为指定值的下标对
 * <p>
 * 给你两个整数数组 nums1 和 nums2 ，请你实现一个支持下述两类查询的数据结构：
 * 累加 ，将一个正整数加到 nums2 中指定下标对应元素上。
 * 计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目（0 <= i < nums1.length 且 0 <= j < nums2.length）。
 * 实现 FindSumPairs 类：
 * FindSumPairs(int[] nums1, int[] nums2) 使用整数数组 nums1 和 nums2 初始化 FindSumPairs 对象。
 * void add(int index, int val) 将 val 加到 nums2[index] 上，即，执行 nums2[index] += val 。
 * int count(int tot) 返回满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目。
 *
 * @author jd95288
 * @date 2025-07-06 16:48
 */
public class FindSumPairs1865 {

    class FindSumPairs {

        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> cnt1 = new HashMap<>();
        Map<Integer, Integer> cnt2 = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            for (int num : nums1) {
                cnt1.merge(num, 1, Integer::sum);
            }
            for (int num : nums2) {
                cnt2.merge(num, 1, Integer::sum);

            }
        }

        public void add(int index, int val) {
            int key = nums2[index];
            cnt2.merge(key, -1, Integer::sum);
            if (cnt2.get(key) <= 0) {
                cnt2.remove(key);
            }
            nums2[index] += val;
            cnt2.merge(key + val, 1, Integer::sum);
        }

        public int count(int tot) {
            int res = 0;
            for (Map.Entry<Integer, Integer> entry : cnt1.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                res += value * cnt2.getOrDefault(tot - key, 0);
            }
            return res;
        }
    }
}
