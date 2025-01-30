package easy;

import java.util.*;

/**
 * 两个数组的交集 II
 * <p>
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 *
 * @author jd95288
 * @date 2025-01-30 21:37
 */
public class Intersect350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : nums1) {
            cnt.merge(i, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            int value = cnt.getOrDefault(i, 0) - 1;
            if (value >= 0) {
                list.add(i);
                cnt.put(i, value);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}
