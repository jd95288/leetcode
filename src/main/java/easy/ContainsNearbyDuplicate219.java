package easy;

import java.util.*;

/**
 * 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2024-07-04 22:36
 */
public class ContainsNearbyDuplicate219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(k);
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (!set.add(nums[right])) {
                return true;
            }
            if (right - left == k) {
                set.remove(nums[left++]);
            }
        }
        return false;
    }

}
