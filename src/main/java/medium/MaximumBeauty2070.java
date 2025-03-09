package medium;

import java.util.Arrays;

/**
 * 每一个查询的最大美丽值
 * <p>
 * 给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。
 * 同时给你一个下标从 0 开始的整数数组 queries 。
 * 对于每个查询 queries[j] ，你想求出价格小于等于 queries[j] 的物品中，最大的美丽值 是多少。
 * 如果不存在符合条件的物品，那么查询的结果为 0 。
 * 请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。
 *
 * @author jd95288
 * @date 2025-03-09 22:44
 */
public class MaximumBeauty2070 {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int[] maxBeauty = new int[n];
        maxBeauty[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int upperbound = bs(queries[i], items);
            if (upperbound >= 0 && upperbound < n) {
                res[i] = maxBeauty[upperbound];
            }
        }
        return res;
    }

    public int bs(int target, int[][] items) {
        int n = items.length;
        int left = 0, right = n - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (items[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return right;
    }

}
