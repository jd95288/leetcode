package medium;

import java.util.List;

/**
 * 数组列表中的最大距离
 * <p>
 * 给定 m 个数组，每个数组都已经按照升序排好序了。
 * 现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。
 * 两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。
 * 返回最大距离。
 *
 * @author jd95288
 * @date 2025-02-19 8:57
 */
public class MaxDistance624 {

    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int preMax = Integer.MIN_VALUE / 2;
        int preMin = Integer.MAX_VALUE / 2;
        for (List<Integer> array : arrays) {
            int n = array.size();
            Integer curMax = array.get(n - 1);
            Integer curMin = array.get(0);
            res = Math.max(res, Math.max(curMax - preMin, preMax - curMin));
            preMax = Math.max(preMax, curMax);
            preMin = Math.min(preMin, curMin);
        }
        return res;
    }

}
