package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 找出最长等值子数组
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
 * 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
 * 子数组 是数组中一个连续且可能为空的元素序列。
 *
 * @author jd95288
 * @date 2024-05-23 0:11
 */
public class LongestEqualSubarray2831 {

    public int longestEqualSubarray_v1(List<Integer> nums, int k) {
        if (nums.size() == 0) {
            return 0;
        }
        int res = 0;
        List<Integer>[] indexMap = new List[100001];
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            if (indexMap[val] == null) {
                indexMap[val] = new ArrayList<>();
            }
            indexMap[val].add(i);
        }
        for (List<Integer> index : indexMap) {
            if (index == null) {
                continue;
            }
            int i = 0;
            ArrayList<Integer> gaps = new ArrayList<>();
            for (int j = 1; j < index.size(); j++) {
                gaps.add(index.get(j) - index.get(i++) - 1);
            }
            int cnt = k;
            int gapNums = 0;
            int left = 0;
            int right = 0;
            while (right < gaps.size()) {
                while (cnt >= 0 && right < gaps.size()) {
                    cnt -= gaps.get(right);
                    if (cnt >= 0) {
                        right++;
                    }
                }
                gapNums = Math.max(gapNums, right - left);
                while (left < gaps.size() && cnt < 0) {
                    cnt += gaps.get(left);
                    left++;
                }
                right++;
            }

            res = Math.max(res, gapNums + 1);
        }
        return res;
    }
}
