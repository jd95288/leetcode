package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 统计完全子数组的数目
 * <p>
 * 给你一个由 正 整数组成的数组 nums 。
 * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
 * 子数组中 不同 元素的数目等于整个数组不同元素的数目。
 * 返回数组中 完全子数组 的数目。
 * 子数组 是数组中的一个连续非空序列。
 *
 * @author jd95288
 * @date 2025-04-24 0:53
 */
public class CountCompleteSubarrays2799 {

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int k = set.size();
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length;
        int left = 0;
        int res = 0;
        for (int right = 0; right < n; right++) {
            cnt.merge(nums[right], 1, Integer::sum);
            while (cnt.size() == k) {
                res += n - right;
                int out = nums[left++];
                if (cnt.merge(out, -1, Integer::sum) == 0) {
                    cnt.remove(out);
                }
            }
        }
        return res;
    }

}
