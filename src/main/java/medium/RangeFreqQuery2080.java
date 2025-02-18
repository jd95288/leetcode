package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区间内查询数字的频率
 * <p>
 * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
 * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
 * 请你实现 RangeFreqQuery 类：
 * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
 * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
 * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
 *
 * @author jd95288
 * @date 2025-02-18 15:57
 */
public class RangeFreqQuery2080 {

    static class RangeFreqQuery {

        public Map<Integer, List<Integer>> valueIndexMap = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                valueIndexMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list = valueIndexMap.get(value);
            if (list == null) {
                return 0;
            }
            return getUpperBound(right, list) - getLowerBound(left, list) + 1;
        }

        public int getUpperBound(int target, List<Integer> list) {
            int l = 0, r = list.size() - 1;
            int m = l + (r - l) / 2;
            while (l <= r) {
                if (list.get(m) > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
                m = l + (r - l) / 2;
            }
            return r;
        }

        public int getLowerBound(int target, List<Integer> list) {
            int l = 0, r = list.size() - 1;
            int m = l + (r - l) / 2;
            while (l <= r) {
                if (list.get(m) < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                m = l + (r - l) / 2;
            }
            return l;
        }


    }

}
