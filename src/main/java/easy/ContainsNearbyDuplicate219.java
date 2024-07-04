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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.get(num) != null && i - map.get(num) <= k) {
                return true;
            } else {
                map.put(num, i);
            }
        }
        return false;
    }

}
