package medium;

/**
 * 最佳观光组合
 * <p>
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *
 * @author jd95288
 * @date 2024-09-23 9:26
 */
public class MaxScoreSightseeingPair1014 {

    public int maxScoreSightseeingPair_v2(int[] values) {
        int n = values.length;
        int maxi = values[0];
        int res = 0;
        for (int j = 1; j < n; j++) {
            res = Math.max(res, values[j] - j + maxi);
            maxi = Math.max(maxi, values[j] + j);
        }
        return res;
    }

}
