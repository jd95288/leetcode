package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计美丽子数组数目
 * <p>
 * 给你一个下标从 0 开始的整数数组nums 。每次操作中，你可以：
 * 选择两个满足 0 <= i, j < nums.length 的不同下标 i 和 j 。
 * 选择一个非负整数 k ，满足 nums[i] 和 nums[j] 在二进制下的第 k 位（下标编号从 0 开始）是 1 。
 * 将 nums[i] 和 nums[j] 都减去 2^k 。
 * 如果一个子数组内执行上述操作若干次后，该子数组可以变成一个全为 0 的数组，那么我们称它是一个 美丽 的子数组。
 * 请你返回数组 nums 中 美丽子数组 的数目。
 * 子数组是一个数组中一段连续 非空 的元素序列。
 *
 * @author jd95288
 * @date 2025-03-06 8:37
 */
public class BeautifulSubarrays2588 {

    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(0, 0);
        long res = 0;
        for (int i = 1; i <= n; i++) {
            prefix = nums[i - 1] ^ prefix;
            Integer cnt = map.getOrDefault(prefix, 0);
            res += cnt;
            map.put(prefix, cnt + 1);
        }
        return res;
    }

}
