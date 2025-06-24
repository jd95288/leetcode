package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出数组中的所有 K 近邻下标
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。K 近邻下标 是 nums 中的一个下标 i ，并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
 * 以列表形式返回按 递增顺序 排序的所有 K 近邻下标。
 *
 * @author jd95288
 * @date 2025-06-24 0:11
 */
public class FindKDistantIndices2200 {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int r = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int l = Math.max(r + 1, i - k);
                r = Math.min(n - 1, i + k);
                for (int j = l; j <= r; j++) {
                    res.add(j);
                }
            }
        }
        return res;
    }

}
