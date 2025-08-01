package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长和谐子序列
 * <p>
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 给你一个整数数组 nums ，请你在所有可能的 子序列 中找到最长的和谐子序列的长度。
 * 数组的 子序列 是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 * @author jd95288
 * @date 2025-06-30 8:46
 */
public class FindLHS {

    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int key = entry.getKey();
            Integer nextVal = cnt.get(key + 1);
            if (nextVal != null) {
                res = Math.max(res, entry.getValue() + nextVal);
            }
        }
        return res;
    }
}
